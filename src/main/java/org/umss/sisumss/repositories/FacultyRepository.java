package org.umss.sisumss.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.umss.sisumss.models.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty,Integer> {

    @Query("SELECT f FROM Faculty f WHERE f.uuid = ?1")
    Faculty findOneByUuid(String uuid);
}
