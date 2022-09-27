package org.umss.sisumss.dtos;


public class FacultyDTO {
    private Integer id;
    private String uuid;
    private String code;
    private String name;
    private UniversityDTO university;
    public FacultyDTO() {
    }

    public FacultyDTO(String uuid, String code, String name) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO universityDTO) {
        this.university= universityDTO;
    }
}
