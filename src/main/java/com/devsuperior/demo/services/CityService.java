package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public CityDTO insert(CityDTO dto) {
        City entity = new City();

        dtoToEntity(dto, entity);

        entity = repository.save(entity);

        return new CityDTO(entity);
    }


    private void dtoToEntity(CityDTO dto, City entity) {
        entity.setName(dto.getName());
    }


}
