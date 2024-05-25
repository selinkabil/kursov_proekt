package bg.tu_varna.sit.a2.f22621625.menu;

import bg.tu_varna.sit.a2.f22621625.models.Event;
import bg.tu_varna.sit.a2.f22621625.models.Seat;
import bg.tu_varna.sit.a2.f22621625.models.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages tickets in the system.
 */
public class TicketManager {
    private static List<Ticket> tickets = new ArrayList<>();

    /**
     * Constructs a new TicketManager.
     */
    public TicketManager() {
    }

    /**
     * Gets the list of tickets.
     *
     * @return the list of tickets
     */
    public List<Ticket> getTickets() {
        return tickets;
    }

    /**
     * Adds a ticket to the system.
     *
     * @param ticket the ticket to add
     */
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * Removes a ticket from the system.
     *
     * @param ticket the ticket to remove
     */
    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    /**
     * Checks for duplicate tickets in the system.
     *
     * @param ticket the ticket to check for duplication
     * @return true if a duplicate ticket is found, false otherwise
     */
    public boolean duplicateTicketCheck(Ticket ticket) {
        for (Ticket t : tickets) {
            if (t.equals(ticket) || ticket.getSeat().isBooked()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds a ticket for a specific event and seat.
     *
     * @param event the event of the ticket
     * @param row   the row of the seat
     * @param seat  the number of the seat
     * @return the ticket if found, null otherwise
     */
    public Ticket findTicket(Event event, int row, int seat) {
        for (Ticket ticket : tickets) {
            if (ticket.getEvent().equals(event) && ticket.getSeat().equals(new Seat(row, seat)))
                return ticket;
        }
        return null;
    }
}
