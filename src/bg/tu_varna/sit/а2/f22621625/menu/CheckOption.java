package bg.tu_varna.sit.à2.f22621625.menu;

import bg.tu_varna.sit.à2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.à2.f22621625.models.Ticket;
import bg.tu_varna.sit.à2.f22621625.models.TicketHandle;
import bg.tu_varna.sit.à2.f22621625.contracts.MenuItem;

import java.util.Map;
import java.util.Scanner;

public class CheckOption implements MenuItem {
    private final TicketHandle ticketSystem;
    private final Scanner scanner;

    public CheckOption(TicketHandle ticketSystem, Scanner scanner) {
        this.ticketSystem = ticketSystem;
        this.scanner = scanner;
    }

    @Override
    public void performAction() throws MainException {
            boolean found=false;
            String[] input = scanner.nextLine().trim().split("\\s+");
            String code = input[0];
            for(Map.Entry<String, Ticket> ticket : ticketSystem.getTickets().entrySet()){
                if(ticket.getKey().equals(code)){
                    System.out.println(ticket.getValue().getSeat());
                    found=true;
                }
            }
            if(!found){
                System.out.println("No ticket found with the given code");
            }
        }

    }
