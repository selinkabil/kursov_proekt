package bg.tu_varna.sit.à2.f22621625.models;

import bg.tu_varna.sit.à2.f22621625.enums.TicketStatus;

public class Ticket {
    private Event event;
    private final Seat seat;
    private final String note;
    private TicketStatus ticketStatus;


    public Ticket(Event event, Seat seat, String note) {
        this.event = event;
        this.seat = seat;
        this.note = note;
        this.ticketStatus=TicketStatus.AVAILABLE;
    }
    public Event getEvent() {
        if(event==null){
            throw new NullPointerException();
        }
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Seat getSeat() {
        return seat;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nTicket for ");
        sb.append("event ").append(event.getName());
        sb.append(", for ");
        sb.append("seat ").append(seat.getRow()+" "+seat.getNumber());
        sb.append(",");
        sb.append(" with note: ").append(note).append("");
        sb.append(",");
        if(ticketStatus.equals(TicketStatus.PAID))
            sb.append("paid");
        return sb.toString();
    }
}
