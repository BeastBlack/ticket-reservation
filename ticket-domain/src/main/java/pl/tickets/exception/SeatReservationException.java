package pl.tickets.exception;

public class SeatReservationException extends RuntimeException {
    public SeatReservationException(String message) {
        super(message);
    }
}
