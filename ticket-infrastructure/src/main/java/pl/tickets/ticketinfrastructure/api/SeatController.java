package pl.tickets.ticketinfrastructure.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.tickets.service.SeatReservationService;

@RestController
@RequestMapping("/seat")
@RequiredArgsConstructor
public class SeatController {
    private final SeatReservationService seatReservationService;

    @PostMapping (value = "/reserve")
    public void reserve(@RequestBody SeatDto seat) {
        seatReservationService.reserve(seat.getRow(), seat.getPlace());
    }

    @PostMapping (value = "/revoke-reservation")
    public void revokeReservation(@RequestBody SeatDto seat) {
        seatReservationService.revokeReservation(seat.getRow(), seat.getPlace());
    }
}
