package com.brymanco.parking.internal.impl;

import com.brymanco.parking.Ticket;
import com.brymanco.parking.internal.ITicketFactory;
import java.time.Instant;
import java.util.UUID;

public class TicketFactoryImpl implements ITicketFactory {

    @Override
    public Ticket createTicket() {
        return new Ticket(UUID.randomUUID(), Instant.now());
    }

}
