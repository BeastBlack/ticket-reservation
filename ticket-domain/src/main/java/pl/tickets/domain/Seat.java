package pl.tickets.domain;

public class Seat {
    public Integer row;
    public Integer place;
    public SeatStatus status;

    public Seat(Integer row, Integer place, SeatStatus status) {
        this.row = row;
        this.place = place;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", place=" + place +
                ", status=" + status +
                '}';
    }
}
