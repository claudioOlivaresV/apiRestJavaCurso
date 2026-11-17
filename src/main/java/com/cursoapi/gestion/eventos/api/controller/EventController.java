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
        List <Event> events =eventService.findAll();
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


}
