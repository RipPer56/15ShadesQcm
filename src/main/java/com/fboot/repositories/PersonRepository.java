package com.fboot.repositories;

import com.fboot.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author RipPer
 */
public interface PersonRepository extends JpaRepository<Person, Long>{

    
}
