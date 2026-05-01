package com.rota.facil.location_service.persistence.persistence;

import com.rota.facil.location_service.persistence.entities.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PlaceRepository extends JpaRepository<PlaceEntity, UUID> {
    @Query(value = """
    SELECT p.* FROM places_tb p
    INNER JOIN trip_places_tb tp ON p.place_id = tp.place_id
    WHERE tp.trip_id = :trip_id
    AND ST_DWithin(p.geom, ST_SetSRID(ST_MakePoint(:longitude, :latitude), 4326)::geography, :ray)
    """, nativeQuery = true)
    Optional<PlaceEntity> findByTripIdAndPoint(
            @Param("trip_id") UUID tripId,
            @Param("latitude") double latitude,
            @Param("longitude") double longitude,
            @Param("ray") int ray
    );
}
