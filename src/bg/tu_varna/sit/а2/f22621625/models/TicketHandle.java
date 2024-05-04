package bg.tu_varna.sit.�2.f22621625.models;


import java.util.*;

public class TicketHandle {
    private final Set<Event> events = new HashSet<>();
    private final Map<String, Ticket> tickets = new HashMap<>();
    private final List<Hall> halls = new ArrayList<>();

    public TicketHandle() {
        initHalls();
    }

    public Set<Event> getEvents() {
        return events;
    }

    public Map<String, Ticket> getTickets() {
        return tickets;
    }

    public Hall findHallByNumber(int number){
        for(Hall h: halls){
            if(h.getNumber()==number)
                return h;
        }
        return null;
    }
    private void initHalls(){
        halls.add(new Hall(1,2,5));
        halls.add(new Hall(2,5,5));
        halls.add(new Hall(3,1,5));
        halls.add(new Hall(4,6,6));

    }

    public String findTicketKey(Seat seat, String date,String name) {
        Event event = findEvent(date,name);
        if (event == null) {
            System.out.println("No event found on this date.");
            return null;
        }
        Ticket ticket;
        for (Map.Entry<String, Ticket> entry : tickets.entrySet()) {
            ticket = entry.getValue();
            if (ticket.getEvent().equals(event) && ticket.getSeat().equals(seat)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void unbook(int row,int seat, String date,String name) {
        String ticketKey = findTicketKey(new Seat(row,seat), date,name);
        if (ticketKey != null) {
            tickets.get(ticketKey).getSeat().setBooked(false);
            tickets.get(ticketKey).getEvent().getHalls().findSeatByRowNumber(row,seat).setBooked(false);
            tickets.remove(ticketKey);
            System.out.println("Booking cancelled for seat: Row " + row + ", Seat " + seat + " at event on " + date);
        } else {
            System.out.println("No booking found for specified seat and event.");
        }
    }


    public void buy(int row, int seat, String date,String name) {
        String ticketKey = findTicketKey(new Seat(row,seat), date,name);
        if (ticketKey != null) {
            tickets.get(ticketKey).setPaid(true);

        } else {
            System.out.println("No booking found for specified seat and event.");
        }
    }


    public Event findEvent(String date,String name){
        Event event = null;
        for (Event e : events) {
            if (e.getDate().equals(date)&& e.getName().equals(name)) {
                event = e;
                break;
            }
        }
        return event;
    }

    public void freeSeats(String date, String eventName) {
        Event event = findEvent(date, eventName);
        if (event != null) {
            System.out.println("Free seats for event: " + eventName + " on " + date);
                List<Seat> freeSeats = event.getHalls().getFreeSeats();
                for (Seat seat : freeSeats) {
                    System.out.println("Hall " + event.getHalls().getNumber() + " Row " + seat.getRow() + " Seat " + seat.getNumber());
                }
        } else {
            System.out.println("Event not found for the given date and name.");
        }
    }

    public void bookings(String date, String eventName) {
        Event event = findEvent(date, eventName);
        if (event != null) {
            System.out.println("Booked tickets:");
            for (Map.Entry<String, Ticket> ticketEntry : tickets.entrySet()) {
                Ticket ticket = ticketEntry.getValue();
                if (ticket.getEvent().equals(event) && !ticket.isPaid()) {
                    System.out.println(ticket);
                }
            }
        } else {
            System.out.println("Event not found for the given date and name.");
        }
    }

    public void bookings(Date date) {
        if (date != null) {
            System.out.println("Booked tickets:");
            for (Map.Entry<String, Ticket> ticketEntry : tickets.entrySet()) {
                Ticket ticket = ticketEntry.getValue();
                if (ticket.getEvent().getDate().equals(date) && !ticket.isPaid()) {
                    System.out.println(ticket);
                }
            }
        } else {
            System.out.println("Invalid date provided.");
        }
    }

    public Seat check(String code){
        for(Map.Entry<String, Ticket> ticket : tickets.entrySet()){
            if(ticket.getKey().equals(code)){
                return ticket.getValue().getSeat();
            }
        }
        return null;
    }
    public void report(String from, String to) {
        System.out.println("Report for all halls from " + from + " to " + to + ":");
        generateReport(from, to, null);
    }

    public void report(String from, String to, Hall hallName) {
        System.out.println("Report for hall " + hallName.getNumber() + " from " + from + " to " + to + ":");
        generateReport(from, to, hallName);
    }

    public void report(Hall hallname) {
        System.out.println("Report for hall " + hallname.getNumber() + ":");
        generateReport(null, null, hallname);
    }

    // TODO: FIX THE DATE COMPARISON

    private void generateReport(String from, String to, Hall hallName) {
        Map<String, Integer> hallTicketsSold = new HashMap<>();
        for (Map.Entry<String, Ticket> ticketEntry : tickets.entrySet()) {
            Ticket ticket = ticketEntry.getValue();
            Event event = ticket.getEvent();
            if ((from == null || event.getDate().compareTo(from)==1) && (to == null || event.getDate().compareTo(to)==-1) && (hallName == null || isEventInHall(event, hallName))) {
                hallTicketsSold.put(event.getName(), hallTicketsSold.getOrDefault(event.getName(), 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : hallTicketsSold.entrySet()) {
            System.out.println("Event: " + entry.getKey() + ", Tickets sold: " + entry.getValue());
        }
    }

    public boolean isEventInHall(Event event, Hall hall) {

        return event.getHalls().equals(hall);
    }


}
