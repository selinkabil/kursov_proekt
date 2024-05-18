package bg.tu_varna.sit.à2.f22621625.models;

import bg.tu_varna.sit.à2.f22621625.exceptions.InvalidArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hall {
    private int number;
    private int numberOfRows;
    private int numberOfSeats;
    private List<Seat> seats;

    public Hall(int number, int numberOfRows, int numberOfSeats) throws InvalidArgument {
        this.number = number;
        setNumberOfRows(numberOfRows);
        setNumberOfSeats(numberOfSeats);
        this.seats= new ArrayList<Seat>();
        initSeats();
    }

    public int getNumber() {
        return number;
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
        for(int i =1; i<=numberOfRows;i++)                      {
            for(int j=1; j<=numberOfSeats; j++) {
                seats.add(new Seat(i, j));
            }
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nHall ");
        sb.append("number: ").append(number);
        return sb.toString();
    }

    public void setNumberOfRows(int numberOfRows) throws InvalidArgument {
        if(numberOfRows<0)
            throw new InvalidArgument("Number of rows cannot be negative number");
        else
            this.numberOfRows = numberOfRows;
    }

    public void setNumberOfSeats(int numberOfSeats) throws InvalidArgument {
        if(numberOfSeats<0)
            throw new InvalidArgument("Number of rows cannot be negative number");
        else
        this.numberOfSeats = numberOfSeats;
    }
}
