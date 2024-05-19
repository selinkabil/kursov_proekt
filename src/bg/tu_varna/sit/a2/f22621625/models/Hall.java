package bg.tu_varna.sit.a2.f22621625.models;

import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a hall where events take place, containing seats.
 */
public class Hall {
    private int number;
    private int numberOfRows;
    private int numberOfSeats;
    private List<Seat> seats;

    /**
     * Constructs a Hall object with the given parameters.
     *
     * @param number        the hall number
     * @param numberOfRows the number of rows in the hall
     * @param numberOfSeats the number of seats per row in the hall
     * @throws InvalidArgument if either numberOfRows or numberOfSeats is negative
     */
    public Hall(int number, int numberOfRows, int numberOfSeats) throws InvalidArgument {
        this.number = number;
        setNumberOfRows(numberOfRows);
        setNumberOfSeats(numberOfSeats);
        this.seats = new ArrayList<>();
        initSeats();
    }

    /**
     * Gets the hall number.
     *
     * @return the hall number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Checks if this hall is equal to another object.
     *
     * @param o the object to compare
     * @return true if the halls have the same number, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hall hall = (Hall) o;
        return number == hall.number;
    }

    /**
     * Generates a hash code for the hall based on its number.
     *
     * @return the hash code value for this hall
     */
    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    /**
     * Gets the list of free seats in the hall.
     *
     * @return a list of free seats in the hall
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
     * Finds a seat in the hall based on its row number and seat number.
     *
     * @param row    the row number of the seat
     * @param number the seat number within the row
     * @return the Seat object if found, otherwise null
     */
    public Seat findSeatByRowNumber(int row, int number) {
        for (Seat seat : seats) {
            if (seat.equals(new Seat(row, number))) {
                return seat;
            }
        }
        return null;
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
     * Sets the number of rows in the hall.
     *
     * @param numberOfRows the number of rows to set
     * @throws InvalidArgument if numberOfRows is negative
     */
    public void setNumberOfRows(int numberOfRows) throws InvalidArgument {
        if (numberOfRows < 0)
            throw new InvalidArgument("Number of rows cannot be negative number");
        else
            this.numberOfRows = numberOfRows;
    }

    /**
     * Sets the number of seats per row in the hall.
     *
     * @param numberOfSeats the number of seats per row to set
     * @throws InvalidArgument if numberOfSeats is negative
     */
    public void setNumberOfSeats(int numberOfSeats) throws InvalidArgument {
        if (numberOfSeats < 0)
            throw new InvalidArgument("Number of rows cannot be negative number");
        else
            this.numberOfSeats = numberOfSeats;
    }

    /**
     * Generates a string representation of the hall.
     *
     * @return a string containing the hall number
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nHall ");
        sb.append("number: ").append(number);
        return sb.toString();
    }
}
