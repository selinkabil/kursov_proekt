package bg.tu_varna.sit.à2.f22621625.models;

public class Ticket {
    private Event event;
    private final Seat seat;
    private final String note;
    private boolean paid;

    public Ticket(Event event, Seat seat, String note) {
        this.event = event;
        this.seat = seat;
        this.note = note;
        this.paid=false;
    }
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Seat getSeat() {
        return seat;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean booked) {
        this.paid = booked;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nTicket\n");
        sb.append("event: '").append(event).append("'");
        sb.append(",\n");
        sb.append("seat: '").append(seat).append("'");
        sb.append(",\n");
        sb.append("note: '").append(note).append("'");
        sb.append(",\n");
        sb.append("paid: ").append(paid);
        return sb.toString();
    }
}
