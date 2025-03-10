-- GENERATED BY flyway quarkus extension at 2025-02-28
CREATE TABLE contact_information
(
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY,
    profile_id BIGINT       NOT NULL,
    type       VARCHAR(255) NOT NULL,
    value      VARCHAR(255) NOT NULL,
    primary key (id)
);

CREATE TABLE menu_items
(
    price         INTEGER      NOT NULL,
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY,
    restaurant_id BIGINT       NOT NULL,
    description   VARCHAR(255) NOT NULL,
    name          VARCHAR(255) NOT NULL,
    primary key (id)
);

CREATE TABLE order_items
(
    quantity     INTEGER NOT NULL,
    id           BIGINT GENERATED BY DEFAULT AS IDENTITY,
    menu_item_id BIGINT  NOT NULL,
    primary key (id)
);

CREATE TABLE orders
(
    state      SMALLINT NOT NULL check (state BETWEEN 0 AND 3),
    id         BIGINT GENERATED BY DEFAULT AS IDENTITY,
    profile_id BIGINT   NOT NULL,
    primary key (id)
);

CREATE TABLE orders_order_items
(
    Order_id BIGINT NOT NULL,
    items_id BIGINT NOT NULL UNIQUE
);

CREATE TABLE profiles
(
    id                BIGINT GENERATED BY DEFAULT AS IDENTITY,
    displayName       VARCHAR(255) NOT NULL,
    name              VARCHAR(255) NOT NULL UNIQUE,
    primaryEmail      VARCHAR(255) NOT NULL UNIQUE,
    profilePictureUrl VARCHAR(255),
    primary key (id)
);

CREATE TABLE restaurants
(
    id                  BIGINT GENERATED BY DEFAULT AS IDENTITY,
    ADDress_city        VARCHAR(255) NOT NULL,
    ADDress_county      VARCHAR(255) NOT NULL,
    ADDress_postal_code VARCHAR(255) NOT NULL,
    ADDress_street      VARCHAR(255) NOT NULL,
    displayName         VARCHAR(255) NOT NULL,
    primary key (id)
);

CREATE TABLE sessions
(
    deadline      TIMESTAMP(6) NOT NULL,
    id            BIGINT GENERATED BY DEFAULT AS IDENTITY,
    organizer_id  BIGINT UNIQUE,
    restaurant_id BIGINT UNIQUE,
    primary key (id)
);

CREATE TABLE sessions_orders
(
    Session_id BIGINT NOT NULL,
    orders_id  BIGINT NOT NULL UNIQUE
);

ALTER TABLE IF EXISTS contact_information
    ADD CONSTRAINT FKhv23s561adw5470k6nwrnai6w
        FOREIGN KEY (profile_id)
            REFERENCES profiles;

ALTER TABLE IF EXISTS menu_items
    ADD CONSTRAINT FKhaqtoboitpl0n541y0sc753my
        FOREIGN KEY (restaurant_id)
            REFERENCES restaurants;

ALTER TABLE IF EXISTS order_items
    ADD CONSTRAINT FKdtfg1f49yr5yye2fpl2xid2xo
        FOREIGN KEY (menu_item_id)
            REFERENCES menu_items;

ALTER TABLE IF EXISTS orders
    ADD CONSTRAINT FKeieprmmaadhys18lur996ikv4
        FOREIGN KEY (profile_id)
            REFERENCES profiles;

ALTER TABLE IF EXISTS orders_order_items
    ADD CONSTRAINT FKjyll3gu3l9d1ekgurrr5xk5ee
        FOREIGN KEY (items_id)
            REFERENCES order_items;

ALTER TABLE IF EXISTS orders_order_items
    ADD CONSTRAINT FK15wm72fk6w2lvwketp3u1u4f5
        FOREIGN KEY (Order_id)
            REFERENCES orders;

ALTER TABLE IF EXISTS sessions
    ADD CONSTRAINT FKbuw0c0aj6x4hh884ig4830rpu
        FOREIGN KEY (organizer_id)
            REFERENCES profiles;

ALTER TABLE IF EXISTS sessions
    ADD CONSTRAINT FK3xj60qc0om6hdajtyb5b5x35i
        FOREIGN KEY (restaurant_id)
            REFERENCES restaurants;

ALTER TABLE IF EXISTS sessions_orders
    ADD CONSTRAINT FKhjb762h861fjoxe7jp3b7ersb
        FOREIGN KEY (orders_id)
            REFERENCES orders;

ALTER TABLE IF EXISTS sessions_orders
    ADD CONSTRAINT FKo7v0eal5fglw755wbtlrnfbi0
        FOREIGN KEY (Session_id)
            REFERENCES sessions;
