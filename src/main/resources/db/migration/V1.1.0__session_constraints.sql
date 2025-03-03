ALTER TABLE sessions
DROP CONSTRAINT sessions_organizer_id_key;

ALTER TABLE sessions
DROP CONSTRAINT sessions_restaurant_id_key;

-- Alter state column in orders table
ALTER TABLE orders ADD COLUMN state_temp VARCHAR(255) NOT NULL;

UPDATE orders
SET state_temp = CASE state
                     WHEN 0 THEN 'OPEN'
                     WHEN 1 THEN 'SUBMITTED'
                     WHEN 2 THEN 'PAYED'
                     WHEN 3 THEN 'REJECTED'
    END;

ALTER TABLE orders DROP COLUMN state;

ALTER TABLE orders RENAME COLUMN state_temp TO state;
-- Alter state: end