INSERT INTO event (
    created, type, payload
)
SELECT
NOW() + random() * INTERVAL '5 minutes' AS created,
(ARRAY['type-a', 'type-b', 'type-c', 'type-d'])[ceil(4 * random())] AS type,
 jsonb_build_object(
	 'userId', gen_random_uuid(),
	 'status', (ARRAY['success', 'failed'])[ceil(1.01 * random())],
	 'sessionId', gen_random_uuid()
 ) AS payload
FROM generate_series(1, 1*1000*1000) s(i)