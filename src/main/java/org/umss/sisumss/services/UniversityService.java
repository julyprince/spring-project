package org.umss.sisumss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.umss.sisumss.dtos.UniversityDTO;
import org.umss.sisumss.dtos.UniversityMapper;
import org.umss.sisumss.exceptions.NotFoundException;
import org.umss.sisumss.models.University;
import org.umss.sisumss.repositories.UniversityRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private UniversityMapper universityMapper;

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
}
