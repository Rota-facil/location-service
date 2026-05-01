package com.rota.facil.location_service.messaging.dto.send;

import java.time.LocalTime;
import java.util.UUID;

public record BusArrivedEventSend(
        UUID tripId,
        UUID placeId,
        LocalTime timeArrived
) {
}
