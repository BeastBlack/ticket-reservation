package pl.tickets.ticketinfrastructure.repository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import pl.tickets.domain.Seat;
import pl.tickets.domain.SeatRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class InMemorySeatRepository implements SeatRepository {
    private final static Map<SeatId, Seat> hall = new HashMap<>();

    @Override
    public Optional<Seat> getSeatByRowAndPlace(Integer row, Integer place) {
        showRepoState();

        var seatId = new SeatId(row, place);
        return Optional.ofNullable(hall.get(seatId));
    }

    @Override
    public void save(Seat seat) {
        hall.put(new SeatId(seat.row, seat.place), seat);
        showRepoState();
    }

    private void showRepoState() {
        log.info("REPO STATE: {}", hall);
    }
}
