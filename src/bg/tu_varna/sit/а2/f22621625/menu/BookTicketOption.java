package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.enums.TicketStatus;
import bg.tu_varna.sit.à2.f22621625.models.Seat;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Date;
import java.util.InputMismatchException;
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
        try {
            String []input=scanner.nextLine().trim().split("\\s+");
            int row = Integer.parseInt(input[0]);
            int seat = Integer.parseInt(input[1]);
            Date date = ticketSystem.parseDate(input[2]);
            String name =input[3];
            String note = input[4];

            String code = createCode(row,seat);

            Ticket ticket = new Ticket(ticketSystem.findEvent(date, name), new Seat(row, seat), note);
            ticket.getSeat().setBooked(true);
            if (ticketSystem.getTickets().containsKey(code) || ticket.getEvent().getHalls().findSeatByRowNumber(row, seat).isBooked()) {
                System.out.println("A ticket with this code/this seat already exists.");
            } else {
                ticket.getEvent().getHalls().findSeatByRowNumber(row, seat).setBooked(true);
                ticket.setTicketStatus(TicketStatus.BOOKED);
                ticketSystem.getTickets().put(code, ticket);

                System.out.println("Successfully added ticket: " + code);
            }
        } catch (NumberFormatException | InputMismatchException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid input format.");
        }
    }

    private String createCode(int row,int seat){

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

}
