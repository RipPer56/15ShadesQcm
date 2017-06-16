package com.fboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fboot.entities.Professeur;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Integer> {

    List<Professeur> findByEmail(String email);

}
