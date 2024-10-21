package com.devsuperior.demo.services;

import com.devsuperior.demo.dto.EventDTO;
import com.devsuperior.demo.entities.City;
import com.devsuperior.demo.entities.Event;
import com.devsuperior.demo.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    @Autowired
    private EventRepository repository;

    @Transactional(readOnly = true)
    public Page<EventDTO> findAllPaged(Pageable pageable) {
        Page<Event> allEntityPaged = repository.findAll(pageable);
        return allEntityPaged.map(x -> new EventDTO(x));
    }

    @Transactional
    public EventDTO insert(EventDTO dto) {
        Event entity = new Event();

        dtoToEntity(dto, entity);

        entity = repository.save(entity);

        return new EventDTO(entity);
    }



    private void dtoToEntity(EventDTO dto, Event entity) {
        entity.setName(dto.getName());
        entity.setUrl(dto.getUrl());
        entity.setDate(dto.getDate());
        entity.setCity(new City(dto.getCityId(), null));
    }



}
