package com.rota.facil.location_service.messaging.producers;

import com.rota.facil.location_service.messaging.dto.send.BusArrivedEventSend;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RabbitLocationEventProducer {
    private final RabbitTemplate rabbitTemplate;

    private String locationExchange;

    private String busArrivedRoutingKey;

    public void busArrivedEvent(UUID tripId, UUID placeId) {
        rabbitTemplate.convertAndSend(locationExchange, busArrivedRoutingKey, new BusArrivedEventSend(tripId, placeId, LocalTime.now()));
    }
}
