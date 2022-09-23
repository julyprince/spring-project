package org.umss.sisumss.controllers;

import org.springframework.web.bind.annotation.*;
import org.umss.sisumss.dtos.GroupDTO;
import org.umss.sisumss.dtos.Profesor;
import org.umss.sisumss.dtos.Schedule;
import org.umss.sisumss.dtos.SubjectDTO;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
public class SubjectController {
    @GetMapping("/subject/{subjectUid}/groups")
    public List<GroupDTO> getAll(){
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Group 1");
        groupDTO.setProfesor(new Profesor(UUID.randomUUID().toString(), "Juan Carlos", "Garcia"));
        groupDTO.setSchedules(Collections.singletonList(new Schedule(DayOfWeek.THURSDAY, "6:45", "8:15")));
        return Collections.singletonList(groupDTO);


        /*GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Group1");
        return Collections.singletonList(groupDTO);*/
    }

    @PostMapping("/subject/{subjectUid}/groups")
    public GroupDTO postSubject(@PathVariable String subjectUid, @RequestBody GroupDTO group){
        group.setUuid(UUID.randomUUID().toString());
        group.setProfesor(new Profesor(group.getProfesor().getUuid(), "Juan Carlos", "Garcia"));
        group.setSubject(new SubjectDTO(group.getSubjectDTO().getUuid(), "intro a la programacion","INTRO101"));
        return group;
        /*GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Group1");
        return Collections.singletonList(groupDTO);*/
    }

    @GetMapping("/subject/{subjectUid}/groups/{uuidGroup}") // detalles de un grupo
    public GroupDTO getDetails(@PathVariable String subjectUid, @PathVariable String uuidGroup) {
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Group 1");
        groupDTO.setProfesor(new Profesor(UUID.randomUUID().toString(), "Juan Carlos", "Garcia"));
        groupDTO.setSchedules(Collections.singletonList(new Schedule(DayOfWeek.THURSDAY, "6:45", "8:15")));
        return groupDTO;




    }
}
