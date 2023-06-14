package pl.tickets.ticketinfrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.tickets.domain.SeatRepository;
import pl.tickets.service.SeatReservationService;

@Configuration
public class CinemaConfiguration {

    @Bean
    public SeatReservationService getSeatReservationService(SeatRepository seatRepository) {
        return new SeatReservationService(seatRepository);
    }
}
