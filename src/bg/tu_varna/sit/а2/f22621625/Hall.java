package bg.tu_varna.sit.à2.f22621625;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hall {
    private int number;
    private int numberOfRows;
    private int numberOfSeats;
    private List<Seat> seats;

    public Hall(int number, int numberOfRows, int numberOfSeats) {
        this.number = number;
        this.numberOfRows = numberOfRows;
        this.numberOfSeats = numberOfSeats;
        this.seats= new ArrayList<Seat>();
        initSeats();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public void setNumberOfRows(int numberOfRows) {
        this.numberOfRows = numberOfRows;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return number == hall.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
    public List<Seat> getFreeSeats() {
        List<Seat> freeSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                freeSeats.add(seat);
            }
        }
        return freeSeats;
    }
    public Seat findSeatByRowNumber(int row,int number){
        for(Seat seat : seats){
            if(seat.equals(new Seat(row, number))){
                return seat;
            }
        }
        return null;
    }
    public void initSeats(){
        for(int i =1; i<=numberOfRows;i++){
            for(int j=1; j<=numberOfSeats; j++) {
                seats.add(new Seat(i, j));
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nHall\n");
        sb.append("number: ").append(number);
        sb.append(",\n");
        sb.append("numberOfRows: ").append(numberOfRows);
        sb.append(",\n");
        sb.append("numberOfSeats: ").append(numberOfSeats);
        sb.append(",\n");
        return sb.toString();
    }
}
