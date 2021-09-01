package com.brymanco.parking.internal.impl;

import com.brymanco.parking.CarSize;
import com.brymanco.parking.internal.ILotManager;
import com.brymanco.parking.Ticket;
import com.brymanco.parking.internal.ILotConfig;
import com.brymanco.parking.internal.ITicketFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.UUID;
import com.brymanco.parking.SpaceInfo;

public class LotManagerImpl implements ILotManager {

    private final Map<CarSize, PriorityQueue<SpaceInfo>> availableSpaces;

    private final Map<UUID, SpaceInfo> ticketStore;

    private final ITicketFactory ticketFactory;

    public LotManagerImpl(
            final ILotConfig lotConfig,
            final ITicketFactory ticketFactory) {
        this.ticketFactory = ticketFactory;

        this.availableSpaces = new HashMap<>();

        this.availableSpaces.put(CarSize.large, new PriorityQueue<>(SpaceInfo.SPACE_COMPARER));
        this.availableSpaces.put(CarSize.medium, new PriorityQueue<>(SpaceInfo.SPACE_COMPARER));
        this.availableSpaces.put(CarSize.small, new PriorityQueue<>(SpaceInfo.SPACE_COMPARER));

        lotConfig.getSpaces().forEach(space -> {
            makeSpaceAvailable(space);
        });

        this.ticketStore = new HashMap<>();

    }

    private void makeSpaceAvailable(final SpaceInfo space) {
        this.availableSpaces.get(space.getSize()).add(space);
    }

    @Override
    public Optional<Ticket> getTicket(final CarSize carSize) {
        Objects.requireNonNull(carSize);

        final SpaceInfo space = this.availableSpaces
                .get(carSize)
                .poll();

        if (space == null) {
            return Optional.empty();
        }

        final Ticket ticket = ticketFactory.createTicket();

        this.ticketStore.put(ticket.getId(), space);

        return Optional.of(ticket);

    }

    @Override
    public SpaceInfo redeemTicket(final Ticket ticket) {
        Objects.requireNonNull(ticket);

        final SpaceInfo space = this.ticketStore.get(ticket.getId());

        Objects.requireNonNull(space);

        makeSpaceAvailable(space);

        return space;

    }

}
