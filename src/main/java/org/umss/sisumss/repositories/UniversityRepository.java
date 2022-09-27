package org.umss.sisumss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.sisumss.models.University;


public interface UniversityRepository  extends JpaRepository<University,Integer> {
    @Query("SELECT u FROM University u WHERE u.uuid = ?1")
    University findOneByUuid(String uuid);
//
//    private static List<University> universityList = new ArrayList<>();
//    private static int idCounter;
//    @PersistenceContext
//    private EntityManager entityManager;
//    static {
//        idCounter = 4;
//        universityList.add(new University(1, UUID.randomUUID().toString(),"Universidad Mayor de San Simon","UMSS", new Date()));
//        universityList.add(new University(2, UUID.randomUUID().toString(),"Universidad del Valle","UNIVALLE", new Date()));
//        universityList.add(new University(3, UUID.randomUUID().toString(),"Universidad Catolica Bolicviana","UCB", new Date()));
//    }
//    public List<University> findAll(){
//        return universityList;
//    }
//
//    public University save(University newUniversity) {
//        entityManager.persist(newUniversity);
//        return newUniversity;
//    }
//
//    public University findOneByUuid(String uuid){
//        return universityList.stream()
//                .filter((university -> university.getUuid().equals(uuid)))
//                .findAny()
//                .orElse(null);
//    }
}
