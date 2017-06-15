package com.fboot.repositories;

import com.fboot.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author RipPer
 */
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT p FROM User p WHERE LOWER(p.project) = LOWER(:project)")
    public List<User> find(@Param("project") String project);
}