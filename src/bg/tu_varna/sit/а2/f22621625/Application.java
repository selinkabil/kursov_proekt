package bg.tu_varna.sit.à2.f22621625;

import bg.tu_varna.sit.à2.f22621625.exceptions.MainException;
import bg.tu_varna.sit.à2.f22621625.models.*;

public class Application {
    public static void main(String[] args) {

        /*Date eventDate1 = new Date(); // Today's date for simplicity
        Date eventDate2 = new Date(eventDate1.getTime() + (1000 * 60 * 60 * 24)); // Tomorrow

        String eventName2 = "Opera";

        // Create halls with seats
        Hall halls1 = new Hall(1, 2, 5);
        Hall halls2 = new Hall(2, 5, 5);
        Hall halls3 = new Hall(3, 1, 5);
        Hall halls4= new Hall(4, 6, 6);

        // Adding events
        try {

            ticketHandle.addEvent(eventDate2, halls2, eventName2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Booking some seats for the first event
        ticketHandle.book(1, 1, eventDate1, "VIP", eventName1); // Booking Row 1, Seat 1
        ticketHandle.book(1, 2, eventDate1, "Regular", eventName1); // Booking Row 1, Seat 2

        // Booking some seats for the second event
        ticketHandle.book(2, 3, eventDate2, "Premium", eventName2); // Booking Hall 3, Row 2, Seat 3
        ticketHandle.book(4, 5, eventDate2, "Standard", eventName2); // Booking Hall 4, Row 4, Seat 5

        // Displaying booked and available seats for both events
        System.out.println("Event 1 - Concert");
        ticketHandle.freeSeats(eventDate1, eventName1);
        ticketHandle.bookings(eventDate1, eventName1);

        System.out.println("Event 2 - Opera");
        ticketHandle.freeSeats(eventDate2, eventName2);
        ticketHandle.bookings(eventDate2, eventName2);

        // Unbooking a seat from the first event
        ticketHandle.unbook(1, 1, eventDate1, eventName1);
        System.out.println("After unbooking Row 1, Seat 1 for Concert:");

        // Displaying the status after unbooking a seat for the first event
        ticketHandle.freeSeats(eventDate1, eventName1);
        ticketHandle.bookings(eventDate1, eventName1);*/
        try {
            Menu menu = new Menu();
            TicketHandle ticketHandle = new TicketHandle();
            String date1="1.12.2023";
            String eventName1 = "Concert";
            menu.handleMenuOptions();
        }
        catch (MainException e){
            System.out.println(e.getMessage());
        }
    }
}