package com.maria.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maria.entity.Station;
import com.maria.persistence.StationDao;

import lombok.Setter;

@Service
public class StationServiceImpl implements StationService {
	@Autowired
	private StationDao dao;
	

	@Override
	public Collection<Station> getAllStations() {

		return dao.findAll();
	}


}
