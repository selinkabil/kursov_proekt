package bg.tu_varna.sit.a2.f22621625.models;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;

/**
 * Represents a ticket for an event.
 */
public class Ticket {
    private Event event;
    private final Seat seat;
    private final String note;
    private TicketStatus ticketStatus;

    /**
     * Constructs a Ticket object with the specified event, seat, and note.
     *
     * @param event the event associated with the ticket
     * @param seat  the seat for the ticket
     * @param note  additional note for the ticket
     */
    public Ticket(Event event, Seat seat, String note) {
        this.event = event;
        this.seat = seat;
        this.note = note;
        this.ticketStatus = TicketStatus.AVAILABLE;
    }

    /**
     * Gets the event associated with the ticket.
     *
     * @return the event
     * @throws NullPointerException if the event is null
     */
    public Event getEvent() {
        if (event == null) {
            throw new NullPointerException();
        }
        return event;
    }

    /**
     * Sets the event associated with the ticket.
     *
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    /**
     * Gets the seat for the ticket.
     *
     * @return the seat
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * Gets the status of the ticket.
     *
     * @return the ticket status
     */
    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    /**
     * Sets the status of the ticket.
     *
     * @param ticketStatus the ticket status to set
     */
    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    /**
     * Returns a string representation of the ticket.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nTicket for ");
        sb.append("event ").append(event.getName());
        sb.append(", for ");
        sb.append("seat ").append(seat.getRow() + " " + seat.getNumber());
        sb.append(",");
        sb.append(" with note: ").append(note).append("");
        sb.append(",");
        if (ticketStatus.equals(TicketStatus.PAID))
            sb.append("paid");
        return sb.toString();
    }
}
