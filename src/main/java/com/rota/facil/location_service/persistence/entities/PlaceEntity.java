package com.rota.facil.location_service.persistence.entities;

import jakarta.persistence.*;
import lombok.*;
import org.locationtech.jts.geom.Point;

import java.util.List;
import java.util.UUID;

@Builder
@Entity
@Table(name = "places_tb")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceEntity {
    @Id
    @Column(name = "place_id")
    private UUID id;

    @Column(columnDefinition = "geography(POINT, 4326)")
    private Point geom;

    @ManyToMany
    @JoinTable(
            name = "trip_places_tb",
            joinColumns = @JoinColumn(name = "place_id"),
            inverseJoinColumns = @JoinColumn(name = "trip_id")
    )
    List<TripEntity> trips;
}
