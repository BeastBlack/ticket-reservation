package pl.tickets.service;

import lombok.RequiredArgsConstructor;
import pl.tickets.domain.Seat;
import pl.tickets.domain.SeatRepository;
import pl.tickets.domain.SeatStatus;
import pl.tickets.exception.SeatReservationException;

import static pl.tickets.domain.CinemaHallConfiguration.HALL_ROW_COUNT;
import static pl.tickets.domain.CinemaHallConfiguration.SEAT_COUNT_PER_ROW;

@RequiredArgsConstructor
public class SeatReservationService {
    private final SeatRepository seatRepository;

    public void reserve(Integer row, Integer place) {
        validate(row, place);

        var seat = seatRepository.getSeatByRowAndPlace(row, place);

        if (seat.isPresent()) {
            if (seat.get().status == SeatStatus.FREE) {
                seat.get().status = SeatStatus.RESERVED;
            } else {
                throw new SeatReservationException("Seat is reserved or confirmed");
            }
        } else {
            seatRepository.save(new Seat(row, place, SeatStatus.RESERVED));
        }
    }

    public void revokeReservation(Integer row, Integer place) {
        validate(row, place);

        var seat = seatRepository.getSeatByRowAndPlace(row, place);

        if (seat.isPresent()) {
            if (seat.get().status != SeatStatus.FREE) {
                seat.get().status = SeatStatus.FREE;
            }
        }
    }

    private void validate(Integer row, Integer place) {
        if (row < 1 || row > HALL_ROW_COUNT || place < 1 || place > SEAT_COUNT_PER_ROW) {
            throw new SeatReservationException("Seat does not exists");
        }
    }
}
