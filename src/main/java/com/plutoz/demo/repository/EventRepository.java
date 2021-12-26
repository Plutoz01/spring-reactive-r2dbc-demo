package com.plutoz.demo.repository;

import com.plutoz.demo.model.Event;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends ReactiveSortingRepository<Event, String> {
}
