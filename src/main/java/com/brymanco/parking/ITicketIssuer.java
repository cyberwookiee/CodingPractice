package com.brymanco.parking;

import java.util.Optional;

public interface ITicketIssuer {

    Optional<Ticket> getTicket(CarSize carSize);

}
