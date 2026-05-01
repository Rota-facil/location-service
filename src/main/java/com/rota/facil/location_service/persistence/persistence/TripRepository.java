package com.rota.facil.location_service.persistence.persistence;

import com.rota.facil.location_service.persistence.entities.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TripRepository extends JpaRepository<TripEntity, UUID> {
}
