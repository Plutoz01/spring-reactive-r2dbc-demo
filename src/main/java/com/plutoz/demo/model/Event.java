package com.plutoz.demo.model;

import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Value
@Table
public class Event {
    @Id
    String id;

    Instant created;
    // TODO: how about using enum?

    String type;
    // TODO: need to fix
//    JsonNode payload;
}
