package org.umss.sisumss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.umss.sisumss.dtos.FacultyDTO;
import org.umss.sisumss.dtos.UniversityDTO;
import org.umss.sisumss.services.UniversityService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {
    @Autowired
    private UniversityService universityService;

    @GetMapping //obtener lista de universidades
    public List<UniversityDTO> getAll() {
        return  universityService.getAllUniversities();
    }

    @GetMapping("/{universityUuid}") //obtiene una universidad especifca segun su uuid
    public UniversityDTO get(@PathVariable String universityUuid) {
        return universityService.getUniversity(universityUuid);
    }
    @PostMapping
    public ResponseEntity<UniversityDTO>create(@RequestBody UniversityDTO universitiDTO) throws URISyntaxException {
       UniversityDTO universityDTO = universityService.save(universitiDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{universityUuid}")
                .buildAndExpand(universityDTO.getUuid())
                .toUri();
        return ResponseEntity
                .created(uri)
                .body(universityDTO);
    }

    @PutMapping("/{universityUuid}")
    public UniversityDTO put(@PathVariable String universityUuid, @RequestBody UniversityDTO universityDTO){
        return new UniversityDTO(universityUuid, "UMSS","Universidad Mayor de San Simon2");
    }

    @DeleteMapping("/{universityUuid}")
    public UniversityDTO delete(@PathVariable String universityUuid){
        return new UniversityDTO(universityUuid, "UMSS","Universidad Mayor de San Simon");
    }
    @GetMapping("/{universityUuid}/faculties")
    public List<FacultyDTO> getFaculty(@PathVariable String universityUuid){//devuelve lista de facultades de una universidad
        return this.universityService.getFaculties(universityUuid);
    }
}
