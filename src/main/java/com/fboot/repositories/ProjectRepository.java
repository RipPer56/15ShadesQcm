    package com.fboot.repositories;

import com.fboot.entities.Project;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author RipPer
 */
public interface ProjectRepository extends JpaRepository<Project, Long>{

    @Query("SELECT p FROM Project p WHERE LOWER(p.name) = LOWER(:name)")
    public List<Project> find(@Param("name") String name);
}
