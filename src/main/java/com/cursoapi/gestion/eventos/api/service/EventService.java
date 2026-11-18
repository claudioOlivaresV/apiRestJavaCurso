package com.cursoapi.gestion.eventos.api.service;

import com.cursoapi.gestion.eventos.api.domain.Event;
import com.cursoapi.gestion.eventos.api.exception.ResourceNotFoundExpection;
import com.cursoapi.gestion.eventos.api.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService implements IEventService {

    private final EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event save(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event findById(Long id) {
        return eventRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExpection("Evento no encontrado con id: " + id));
    }

    @Override
    public void deleteById(Long id) {
        Event eventToDelete = findById(id); // Verificar si el evento existe antes de eliminarlo
        eventRepository.delete(eventToDelete);
    }
}
