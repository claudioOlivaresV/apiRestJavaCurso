package com.cursoapi.gestion.eventos.api.mapper;

import com.cursoapi.gestion.eventos.api.domain.Event;
import com.cursoapi.gestion.eventos.api.dto.EventRequestDto;
import com.cursoapi.gestion.eventos.api.dto.EventResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntity(EventRequestDto eventRequestDto);
    EventResponseDto toResponseDto(Event event);
    List<EventResponseDto> toEventResponseDtos(List<Event> events);
}
