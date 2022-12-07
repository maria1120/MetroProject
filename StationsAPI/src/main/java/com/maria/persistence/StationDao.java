package com.maria.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maria.demo.entity.Station;

@Repository
public interface StationDao extends JpaRepository<Station, Integer>{

}
