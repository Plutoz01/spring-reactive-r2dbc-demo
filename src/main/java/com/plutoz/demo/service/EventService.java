package com.plutoz.demo.service;

import com.plutoz.demo.model.Event;
import com.plutoz.demo.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class EventService {
    private static final Sort DEFAULT_SORT = Sort.by(Sort.Order.by("id"));

    private final EventRepository repository;

    public Flux<Event> findAll() {
        return repository.findAll(DEFAULT_SORT);
    }
}
