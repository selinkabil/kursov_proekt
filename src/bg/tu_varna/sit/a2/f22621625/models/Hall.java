package bg.tu_varna.sit.a2.f22621625.models;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hall {
    private int number;
    private int numberOfRows;
    private int numberOfSeats;
    private List<Seat> seats;

    /**
     * Constructs a Hall object with the specified number, number of rows, and number of seats.
     *
     * @param number        the number of the hall
     * @param numberOfRows the number of rows in the hall
     * @param numberOfSeats the number of seats in each row of the hall
     * @throws InvalidArgument if any of the parameters are invalid (negative)
     */
    public Hall(int number, int numberOfRows, int numberOfSeats) throws InvalidArgument {
        this.number = number;
        setNumberOfRows(numberOfRows);
        setNumberOfSeats(numberOfSeats);
        this.seats = new ArrayList<>();
        initSeats();
    }

    public int getNumber() {
        return number;
    }

    /**
     * Gets the seat at the specified row and number.
     *
     * @param row    the row of the seat
     * @param number the number of the seat
     * @return the seat at the specified row and number
     */
    public Seat getSeat(int row, int number) {
        return seats.get((row - 1) * numberOfSeats + (number - 1));
    }

    /**
     * Initializes the seats in the hall.
     */
    public void initSeats() {
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= numberOfSeats; j++) {
                seats.add(new Seat(i, j));
            }
        }
    }

    /**
     * Gets the list of free seats in the hall.
     *
     * @return the list of free seats in the hall
     */
    public List<Seat> getFreeSeats() {
        List<Seat> freeSeats = new ArrayList<>();
        for (Seat seat : seats) {
            if (!seat.isBooked()) {
                freeSeats.add(seat);
            }
        }
        return freeSeats;
    }

    /**
     * Sets the number of rows in the hall.
     *
     * @param numberOfRows the number of rows to set
     * @throws InvalidArgument if the number of rows is negative
     */
    public void setNumberOfRows(int numberOfRows) throws InvalidArgument {
        if (numberOfRows < 0)
            throw new InvalidArgument("Number of rows cannot be negative number");
        else
            this.numberOfRows = numberOfRows;
    }

    /**
     * Sets the number of seats in each row of the hall.
     *
     * @param numberOfSeats the number of seats to set
     * @throws InvalidArgument if the number of seats is negative
     */
    public void setNumberOfSeats(int numberOfSeats) throws InvalidArgument {
        if (numberOfSeats < 0)
            throw new InvalidArgument("Number of seats cannot be negative number");
        else
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

    @Override
    public String toString() {
        return "Hall number: " + number;
    }
}
