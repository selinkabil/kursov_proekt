package bg.tu_varna.sit.a2.f22621625.models;

/**
 * Represents a seat in a hall.
 */
public class Seat {
    private int row;
    private int number;
    private boolean booked=false;

    /**
     * Constructs a Seat object with the specified row and seat number.
     *
     * @param row    the row number of the seat
     * @param number the seat number
     */
    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
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
     * Gets the seat number.
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
     * Sets the booked status of the seat.
     *
     * @param booked true if the seat is booked, false otherwise
     */
    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    /**
     * Compares this seat to the specified object. The result is true if and only if the argument is not null and is a Seat object that represents the same row and seat number.
     *
     * @param o the object to compare
     * @return true if the seats are equal, false otherwise
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
     * Returns a hash code value for the seat.
     *
     * @return the hash code
     */
    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + number;
        return result;
    }

    /**
     * Returns a string representation of the seat.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nSeat ");
        sb.append("row: ").append(row);
        sb.append(", ");
        sb.append("number: ").append(number);
        sb.append(",\n");
        sb.append("booked: ").append(booked);
        return sb.toString();
    }
}
