package org.umss.sisumss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;
import org.umss.sisumss.dtos.FacultyDTO;
import org.umss.sisumss.dtos.FacultyMapper;
import org.umss.sisumss.dtos.UniversityDTO;
import org.umss.sisumss.dtos.UniversityMapper;
import org.umss.sisumss.exceptions.NotFoundException;
import org.umss.sisumss.models.Faculty;
import org.umss.sisumss.models.University;
import org.umss.sisumss.repositories.FacultyRepository;
import org.umss.sisumss.repositories.UniversityRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private UniversityMapper universityMapper;
    @Autowired
    private FacultyMapper facultyMapper;
    @Autowired
    private FacultyRepository facultyRepository;

    public List<UniversityDTO> getAllUniversities(){
        return universityRepository.findAll()
                .stream()
                .map(university -> universityMapper.toDTO((university)))
                .collect(Collectors.toList());
    }

    public UniversityDTO getUniversity(String universityUuid) {
        University university = universityRepository.findOneByUuid(universityUuid);

        if (university == null) {
            throw new NotFoundException("university", universityUuid);
        }
        return universityMapper.toDTO(university);
    }

    public UniversityDTO save(UniversityDTO universityDTO) {
        University university = universityMapper.getUniversity(universityDTO);
        return universityMapper.toDTO(universityRepository.save(university));
    }

    public List<FacultyDTO> getFaculties(String universityUuid) {
        University example1 = new University();
        example1.setUuid(universityUuid);
        Optional<University> optionalUniversity = universityRepository.findOne(Example.of(example1));

        if (optionalUniversity.isEmpty()){
            throw  new NotFoundException("University", universityUuid);
        }
        University university = optionalUniversity.get();

        Faculty example = new Faculty();
        University universityExample = new University();
        universityExample.setId(university.getId());
        example.setUniversity(universityExample);

        List<Faculty> faculties = facultyRepository.findAll(Example.of(example));
        return faculties
                .stream()
                .map(faculty -> facultyMapper.toDTO(faculty))
                        .collect(Collectors.toList());
    }
}
