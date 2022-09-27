package org.umss.sisumss.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.umss.sisumss.dtos.FacultyDTO;
import org.umss.sisumss.services.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculties")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @GetMapping("/{facultyUuid}")
    public FacultyDTO get(@PathVariable String facultyUuid){ //devuelve una facultades
        return facultyService.getFaculty(facultyUuid);
    }

    @PostMapping
    public FacultyDTO create(@RequestBody FacultyDTO facultyDTO){ //devuelve la lista de facultades
        return facultyService.saveFaculty(facultyDTO);
    }
}
