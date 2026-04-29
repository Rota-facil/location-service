CREATE TABLE IF NOT EXISTS places_tb(
    place_id UUID NOT NULL PRIMARY KEY,
    geom geography NOT NULL
);