package com.fboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fboot.entities.Resultat;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat,Integer>{

		List<Resultat> findByEtudiantID(int id);
}
