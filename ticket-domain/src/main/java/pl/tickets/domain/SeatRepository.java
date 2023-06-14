package pl.tickets.domain;

import java.util.Optional;

public interface SeatRepository {
    Optional<Seat> getSeatByRowAndPlace(Integer row, Integer place);

    void save(Seat seat);
}
