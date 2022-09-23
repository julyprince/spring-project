package org.umss.sisumss.repositories;

import org.springframework.stereotype.Component;
import org.umss.sisumss.models.University;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class UniversityRepository {
    private static List<University> universityList = new ArrayList<>();
    private static int idCounter;
    static {
        idCounter = 4;
        universityList.add(new University(1, UUID.randomUUID().toString(),"Universidad Mayor de San Simon","UMSS", new Date()));
        universityList.add(new University(2, UUID.randomUUID().toString(),"Universidad del Valle","UNIVALLE", new Date()));
        universityList.add(new University(3, UUID.randomUUID().toString(),"Universidad Catolica Bolicviana","UCB", new Date()));
    }
    public List<University> findAll(){
        return universityList;
    }

    public University save(University newUniversity) {
        newUniversity.setId(idCounter);
        newUniversity.setUuid(UUID.randomUUID().toString());
        universityList.add(newUniversity);
        idCounter++;
        return newUniversity;
    }

    public University findOneByUuid(String uuid){
        return universityList.stream()
                .filter((university -> university.getUuid().equals(uuid)))
                .findAny()
                .orElse(null);
    }
}
