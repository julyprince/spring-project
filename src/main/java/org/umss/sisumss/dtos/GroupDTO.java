package org.umss.sisumss.dtos;

import java.util.List;

public class GroupDTO {

    private Long id;
    private String uuid;
    private String code;
    private String name;
    private Profesor profesor;
    private List<Schedule> schedules;
    private SubjectDTO subjectDTO;
    public GroupDTO() {
    }

    public GroupDTO(String uuid, String code, String name) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<Schedule> getSchedule() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }

    public void setSubject(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }

}
