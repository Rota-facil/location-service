package com.rota.facil.location_service.business;

import com.rota.facil.location_service.messaging.producers.RabbitLocationEventProducer;
import com.rota.facil.location_service.persistence.entities.PlaceEntity;
import com.rota.facil.location_service.persistence.persistence.PlaceRepository;
import com.rota.facil.location_service.persistence.persistence.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final PlaceRepository placeRepository;
    private final TripRepository tripRepository;
    private final RabbitLocationEventProducer locationEventProducer;

    public void inferArrival(UUID tripId, double latitude, double longitude) {
        Optional<PlaceEntity> placeExisting = placeRepository.findByTripIdAndPoint(tripId, latitude, longitude, 20);

        if (placeExisting.isEmpty()) return;

        locationEventProducer.busArrivedEvent(tripId, placeExisting.get().getId());
    }
}
