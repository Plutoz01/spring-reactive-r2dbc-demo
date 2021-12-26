CREATE TABLE event (
    id BIGSERIAL NOT NULL,
    created timestamp with time zone NOT NULL,
    type varchar(50) NOT NULL,
    payload jsonb,

    CONSTRAINT event_pkey PRIMARY KEY (id)
);

GRANT SELECT ON TABLE event TO demo;

