package com.plutoz.demo.controller;

import com.plutoz.demo.model.Event;
import com.plutoz.demo.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import static org.springframework.http.MediaType.*;

@RestController
@RequestMapping("api/v1/event")
@RequiredArgsConstructor
public class EventController {
    private static final int JSON_EVENT_LIMIT = 10000;
    private final EventService eventService;

    // Server Sent Events
    @GetMapping(path = "stream", produces = TEXT_EVENT_STREAM_VALUE)
    public Flux<Event> stream() {
        return eventService.findAll();
    }

    // New-line delimited JSON
    @GetMapping(path = "ndjson", produces = APPLICATION_NDJSON_VALUE)
    public ResponseEntity<Flux<Event>> getNdJson() {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=events.ndjson")
                .body(eventService.findAll());
    }

    @GetMapping(path = "json")
    public ResponseEntity<Flux<Event>> getJson() {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=events.json")
                .body(eventService.findAll()
                        .take(JSON_EVENT_LIMIT)
                );
    }
}
