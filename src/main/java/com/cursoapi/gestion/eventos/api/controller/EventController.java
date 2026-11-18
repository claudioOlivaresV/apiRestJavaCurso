package com.cursoapi.gestion.eventos.api.controller;

import com.cursoapi.gestion.eventos.api.domain.Event;
import com.cursoapi.gestion.eventos.api.dto.EventRequestDto;
import com.cursoapi.gestion.eventos.api.dto.EventResponseDto;
import com.cursoapi.gestion.eventos.api.mapper.EventMapper;
import com.cursoapi.gestion.eventos.api.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;
    private final EventMapper eventMapper;

    @GetMapping
    public List<EventResponseDto> getAllEvents() {
        List<Event> events = eventService.findAll();
        return eventMapper.toEventResponseDtos(events);
    }

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventRequestDto requestDto) {
        Event eventToSave = eventMapper.toEntity(requestDto);
        Event savedEvent = eventService.save(eventToSave);
//        return eventMapper.toResponseDto(savedEvent);
        EventResponseDto eventresponseDto = eventMapper.toResponseDto(savedEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventresponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponseDto> getEventById(@PathVariable Long id) {
        Event event = eventService.findById(id);
        EventResponseDto eventResponseDto = eventMapper.toResponseDto(event);
        return ResponseEntity.ok(eventResponseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventResponseDto> updateEvent(@PathVariable Long id, @Valid @RequestBody EventRequestDto requestDto) {
        Event existingEvent = eventService.findById(id);
        eventMapper.updateEventFromDto(requestDto, existingEvent);
        Event updatedEvent = eventService.save(existingEvent);
        EventResponseDto eventResponseDto = eventMapper.toResponseDto(updatedEvent);
        return ResponseEntity.ok(eventResponseDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
