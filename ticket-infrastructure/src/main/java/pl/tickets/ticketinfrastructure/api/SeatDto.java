package pl.tickets.ticketinfrastructure.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SeatDto {
    private Integer row;
    private Integer place;
}
