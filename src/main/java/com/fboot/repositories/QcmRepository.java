package com.fboot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fboot.entities.Qcm;



@Repository
public interface QcmRepository extends JpaRepository<Qcm,Integer>{
	List<Qcm> findByType(String type);
	List<Qcm> findByProfesseurID(int id);
}
