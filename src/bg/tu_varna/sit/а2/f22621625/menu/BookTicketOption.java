package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.models.Seat;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Random;
import java.util.Scanner;

public class BookTicketOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    public BookTicketOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    @Override
    public void performAction() {
        int row=scanner.nextInt();
        int seat=scanner.nextInt();
        String date=scanner.next();
        String name=scanner.next();
        String note=scanner.next();
        StringBuilder sb = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        sb.append(row);
        sb.append(seat);
        for(int i=0; i<6; i++){
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        Ticket ticket = new Ticket(ticketSystem.findEvent(date,name),new Seat(row,seat),note);
        ticket.getEvent().getHalls().findSeatByRowNumber(row,seat).setBooked(true);
        ticket.getSeat().setBooked(true);
        if (ticketSystem.getTickets().containsKey(sb.toString())) {
            System.out.println("A ticket with this code already exists.");
        } else {
            ticketSystem.getTickets().put(sb.toString(),ticket);
            System.out.println("Successfully added ticket: " + sb);
        }
    }
}
