package com.fboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fboot.entities.Etudiant;


@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Integer>{
	 List<Etudiant> findByEmail(String email);

}
