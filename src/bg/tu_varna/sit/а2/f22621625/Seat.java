package bg.tu_varna.sit.à2.f22621625;

public class Seat {
    private int row;
    private int number;
    private boolean booked;

    public Seat(int row, int number) {
        this.row = row;
        this.number = number;
        this.booked=false;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (row != seat.row) return false;
        return number == seat.number;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nSeat\n");
        sb.append("row: ").append(row);
        sb.append(",\n");
        sb.append("number: ").append(number);
        sb.append(",\n");
        sb.append("booked: ").append(booked);
        return sb.toString();
    }
}
