package com.brymanco.parking;

import java.time.Instant;
import java.util.UUID;

public class Ticket {

    private final Instant isssued;

    private final UUID id;

    public Ticket(UUID id, Instant isssued) {
        this.isssued = isssued;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public Instant getIssued() {
        return isssued;
    }
}
