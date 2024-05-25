package bg.tu_varna.sit.a2.f22621625.models;

/**
 * Represents a seat in a hall with a row number and seat number.
 * A seat can be booked or unbooked.
 */
public class Seat {
    private int row;
    private int number;
    private boolean booked;

    /**
     * Constructs a new Seat with the specified row and number.
     * Initially, the seat is not booked.
     *
     * @param row    the row number of the seat
     * @param number the seat number within the row
     */
    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
        this.booked = false;
    }

    /**
     * Gets the row number of the seat.
     *
     * @return the row number
     */
    public int getRow() {
        return row;
    }

    /**
     * Gets the seat number within the row.
     *
     * @return the seat number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Checks if the seat is booked.
     *
     * @return true if the seat is booked, false otherwise
     */
    public boolean isBooked() {
        return booked;
    }

    /**
     * Sets the booking status of the seat.
     *
     * @param booked true to book the seat, false to unbook it
     */
    public void setBooked(boolean booked) {
        this.booked = booked;
    }


    /**
     * Compares this seat to the specified object.
     * The result is true if and only if the argument is not null and is a Seat object that represents the same row and seat number.
     *
     * @param o the object to compare this Seat against
     * @return true if the given object represents a Seat equivalent to this seat, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (row != seat.row) return false;
        return number == seat.number;
    }

    /**
     * Returns a hash code for this seat.
     * The hash code is computed based on the row and seat number.
     *
     * @return a hash code value for this seat
     */
    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + number;
        return result;
    }

    /**
     * Returns a string representation of this seat.
     * The string representation consists of the row, seat number, and booking status.
     *
     * @return a string representation of this seat
     */
    @Override
    public String toString() {
        return "Seat{" +
                "row=" + row +
                ", number=" + number +
                ", booked=" + booked +
                '}';
    }
}
