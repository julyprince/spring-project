package org.umss.sisumss.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.umss.sisumss.dtos.GroupDTO;
import org.umss.sisumss.dtos.Profesor;
import org.umss.sisumss.dtos.Schedule;
import org.umss.sisumss.dtos.SubjectDTO;

import javax.security.auth.Subject;
import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class ProfessorController {
    @GetMapping("/profesors/{profesorUID}/groups")
    public List<GroupDTO> getAllGroups(@PathVariable String profesorUID){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Group 1");
        groupDTO.setSubject(new SubjectDTO(UUID.randomUUID().toString(), "Intro a la Programacion", "INTRO01"));
        groupDTO.setSchedules(Collections.singletonList(new Schedule(DayOfWeek.THURSDAY, "6:45", "8:15")));
        return Collections.singletonList(groupDTO);

    }
}
