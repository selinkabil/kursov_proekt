package bg.tu_varna.sit.a2.f22621625.models;

import bg.tu_varna.sit.a2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.a2.f22621625.exceptions.InvalidArgument;

import java.util.Random;

/**
 * Represents a ticket for an event.
 */
public class Ticket {
    private String code;
    private final Seat seat;
    private final String note;
    private Event event;
    private TicketStatus ticketStatus;


    public Ticket(Event event, int row, int seat, String note) {
        this.code = createCode(row, seat);
        this.seat = event.getHall().getSeat(row, seat);
        this.note = note;
        this.event = event;
        this.ticketStatus = TicketStatus.AVAILABLE; // Initially, ticket is available
    }

    /**
     * Creates a unique code for the ticket.
     *
     * @param row  the row number of the seat.
     * @param seat the seat number.
     * @return the generated unique code.
     */
    private String createCode(int row, int seat) {
        StringBuilder sb = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        sb.append(row);
        sb.append(seat);
        for (int i = 0; i < 6; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
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

    public String getCode() {
        return code;
    }

    public Event getEvent() {
        return event;
    }

    /**
     * Sets the status of the ticket.
     *
     * @param ticketStatus the ticket status to set
     */
    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        return code.equals(ticket.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    /**
     * Returns a string representation of the ticket.
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nTicket with ");
        sb.append("code ").append(code);
        sb.append(", for event ").append(event);
        sb.append("seat ").append(seat.getRow() + " " + seat.getNumber());
        sb.append(",");
        sb.append(" with note: ").append(note);
        sb.append(",");
        if (ticketStatus.equals(TicketStatus.PAID))
            sb.append("paid");
        return sb.toString();
    }
}
