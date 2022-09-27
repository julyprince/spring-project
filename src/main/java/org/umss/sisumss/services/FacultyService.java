package org.umss.sisumss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.umss.sisumss.dtos.FacultyDTO;
import org.umss.sisumss.dtos.FacultyMapper;
import org.umss.sisumss.dtos.UniversityDTO;
import org.umss.sisumss.exceptions.NotFoundException;
import org.umss.sisumss.models.Faculty;
import org.umss.sisumss.models.University;
import org.umss.sisumss.repositories.FacultyRepository;
import org.umss.sisumss.repositories.UniversityRepository;

import java.util.List;

@Component
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;
    @Autowired
    private FacultyMapper facultyMapper;
    @Autowired
    private UniversityRepository universityRepository;


    public FacultyDTO getFaculty(String facultyUuid) {
        Faculty faculty = facultyRepository.findOneByUuid(facultyUuid);
        if (faculty == null){
            throw new NotFoundException("faculty: ", facultyUuid);
        }
        return facultyMapper.toDTO(faculty);
    }


    public FacultyDTO saveFaculty(FacultyDTO facultyDTO){
        UniversityDTO universityDTO = facultyDTO.getUniversity();
        if (universityDTO==null) {
            throw new NotFoundException("University: ",null); //pasa cuando no me mandan el uuid de la universidad
        }
       University university = universityRepository.findOneByUuid(universityDTO.getUuid());
        if (university == null){
            throw new NotFoundException("University: ",universityDTO.getUuid().toString()); // el uuid no se encuentra en la base de datos
        }
        Faculty faculty = facultyMapper.getFaculty(facultyDTO, university);//pido al maper la facultad
        facultyRepository.save(faculty);
        return facultyMapper.toDTO(faculty);
    }
}
