ALTER TABLE orders_order_items
    RENAME TO orders_items;

ALTER TABLE sessions
DROP
CONSTRAINT sessions_organizer_id_key;

ALTER TABLE sessions
DROP
CONSTRAINT sessions_restaurant_id_key;

ALTER TABLE orders
ALTER
COLUMN state
      TYPE VARCHAR(255)
      USING CASE state
WHEN 0 THEN 'OPEN'
WHEN 1 THEN 'SUBMITTED'
WHEN 2 THEN 'PAYED'
WHEN 3 THEN 'REJECTED'
END;