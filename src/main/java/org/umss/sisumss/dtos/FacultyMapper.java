package org.umss.sisumss.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.umss.sisumss.models.Faculty;
import org.umss.sisumss.models.University;

@Component
public class FacultyMapper {
    @Autowired
    private UniversityMapper universityMapper;
    public FacultyDTO toDTO(Faculty faculty){ //convierte modelo faculty a FacultyDTO
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setUuid(faculty.getUuid());
        facultyDTO.setCode(faculty.getCode());
        facultyDTO.setName(faculty.getName());
        facultyDTO.setUniversity(universityMapper.toDTO(faculty.getUniversity()));
        return facultyDTO;
    }

    public Faculty getFaculty(FacultyDTO facultyDTO, University university){ //convierte de TDO a modelo faculty
        Faculty faculty = new Faculty();
        faculty.setUuid(facultyDTO.getUuid());
        faculty.setCode(facultyDTO.getCode());
        faculty.setName(facultyDTO.getName());
        faculty.setUniversity(university);
        return faculty;
    }
}
