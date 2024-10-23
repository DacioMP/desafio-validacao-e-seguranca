package com.devsuperior.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;

@Service
public class CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Transactional(readOnly = true)
	public List<City> findAll() {
		return cityRepository.findAll(Sort.by("name"));
	}
	
	@Transactional
	public CityDTO insert(CityDTO dto) {
		City entity = new City(null, dto.getName());
		entity = cityRepository.save(entity);
		return new CityDTO(entity);
	}
}
