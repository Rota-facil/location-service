CREATE TABLE IF NOT EXISTS trip_places_tb (
    trip_id UUID NOT NULL,
    place_id UUID NOT NULL,

    PRIMARY KEY(trip_id, place_id),
    CONSTRAINT fk_trip_places_trips FOREIGN KEY (trip_id) REFERENCES trips_tb(trip_id),
    CONSTRAINT fk_trip_places_places FOREIGN KEY (place_id) REFERENCES places_tb(place_id)
);