package com.rota.facil.location_service.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Builder
@Entity
@Table(name = "trips_tb")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class TripEntity {
    @Id
    @Column(name = "trip_id")
    private UUID id;
}
