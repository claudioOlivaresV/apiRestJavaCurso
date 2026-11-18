package com.cursoapi.gestion.eventos.api.service;

import com.cursoapi.gestion.eventos.api.domain.Event;

import java.util.List;

public interface IEventService {
    List<Event> findAll();
    Event save(Event event);
    Event findById(Long id);
    void deleteById(Long id);
}
