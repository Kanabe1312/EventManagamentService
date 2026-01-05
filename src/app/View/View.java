package app.View;

import app.Events.Event;
import app.Events.EventsService;
import app.Participants.Participant;
import app.Participants.ParticipantsService;
import app.Tickets.Ticket;
import app.Tickets.TicketService;
import app.User.User;
import app.User.UserService;

import java.util.List;
import java.util.Scanner;

public class View {

    public EventsService eventsService = new EventsService();
    public UserService userService = new UserService();
    public TicketService ticketService = new TicketService();
    public ParticipantsService participantsService = new ParticipantsService();

    public User logat = null;

    Scanner sc = new Scanner(System.in);
    public void loadData() {
        eventsService.loadEvents();
        userService.loadUsers();
        ticketService.loadTickets();
        participantsService.loadParticipants();
    }

    public void meniu() {
        System.out.println("\n=== EVENT MANAGEMENT SYSTEM ===");
        System.out.println("1 - Login");
        System.out.println("2 - Show events");
        System.out.println("3 - Register to event");
        System.out.println("4 - My events");
        System.out.println("5 - Show participants for event");
        System.out.println("6 - Show tickets for event");
        System.out.println("7 - Cancel registration");
        System.out.println("8 - Event statistics");


        System.out.println("0 - Exit");
    }


    public void play() {
        loadData();

        while (true) {
            meniu();
            int opt = Integer.parseInt(sc.nextLine());

            switch (opt) {
                case 1:
                    login();
                    break;
                case 2:
                    showEvents();
                    break;
                case 3:
                    registerToEvent();
                    break;
                case 4:
                    showMyEvents();
                    break;
                case 5:
                    showParticipantsForEvent();
                    break;
                case 6:
                    showTicketsForEvent();
                    break;
                case 7:
                    cancelRegistration();
                    break;
                case 8:
                    showEventStatistics();
                    break;
                case 0:
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    public void login() {
        System.out.println("Email:");
        String email = sc.nextLine();

        User u = userService.getUserByEmail(email);
        if (u == null) {
            System.out.println("User not found!");
            return;
        }

        logat = u;
        System.out.println("Login successful!");
    }

    public void showEvents() {
        System.out.println("=== EVENTS ===");

        for (int i = 0; i < eventsService.events.size(); i++) {
            Event e = eventsService.events.get(i);
            System.out.println(e.descriptionEvent());
            System.out.println("--------");
        }
    }

    public void registerToEvent() {

        if (logat == null) {
            System.out.println("Please login first!");
            return;
        }

        System.out.println("Enter Event ID:");
        int eventId = Integer.parseInt(sc.nextLine());

        Event e = eventsService.getEventById(eventId);
        if (e == null) {
            System.out.println("Event not found!");
            return;
        }

        boolean success = participantsService.registerUserToEvent(
                eventId,
                logat.id,
                1
        );

        if (success) {
            System.out.println("Registered successfully!");
        } else {
            System.out.println("You are already registered!");
        }
    }
    public void showParticipantsForEvent() {

        System.out.println("Enter Event ID:");
        int eventId = Integer.parseInt(sc.nextLine());

        List<Participant> list = participantsService.getParticipantsByEventId(eventId);

        if (list.size() == 0) {
            System.out.println("No participants found!");
            return;
        }

        System.out.println("=== PARTICIPANTS ===");

        for (int i = 0; i < list.size(); i++) {
            Participant p = list.get(i);
            User u = userService.getUserById(p.userId);

            if (u != null) {
                System.out.println("Name: " + u.fullName);
                System.out.println("Email: " + u.email);
                System.out.println("Role: " + p.role);
                System.out.println("--------");
            }
        }
    }
    public void showTicketsForEvent() {

        System.out.println("Enter Event ID:");
        int eventId = Integer.parseInt(sc.nextLine());

        List<Ticket> tickets = ticketService.getTicketsForEvent(eventId);

        if (tickets.size() == 0) {
            System.out.println("No tickets found!");
            return;
        }

        System.out.println("=== TICKETS ===");

        for (int i = 0; i < tickets.size(); i++) {
            System.out.println(tickets.get(i).descriptionTicket());
            System.out.println("--------");
        }
    }
    public void showMyEvents() {

        if (logat == null) {
            System.out.println("Please login first!");
            return;
        }

        List<Integer> eventIds =
                participantsService.getEventIdsByUserId(logat.id);

        if (eventIds.size() == 0) {
            System.out.println("You are not registered to any event!");
            return;
        }

        List<Event> myEvents =
                eventsService.getEventsByIds(eventIds);

        System.out.println("\n=== MY EVENTS ===");
        for (int i = 0; i < myEvents.size(); i++) {
            System.out.println(myEvents.get(i).descriptionEvent());
            System.out.println("------------");
        }
    }
    public void cancelRegistration() {

        if (logat == null) {
            System.out.println("Please login first!");
            return;
        }

        System.out.println("Enter Event ID:");
        int eventId = Integer.parseInt(sc.nextLine());

        boolean ok = participantsService.cancelRegistration(eventId, logat.id);

        if (ok) {
            System.out.println("Registration cancelled!");
        } else {
            System.out.println("You are not registered to this event!");
        }
    }
    public void showEventStatistics() {

        System.out.println("Enter Event ID:");
        int eventId = Integer.parseInt(sc.nextLine());

        int participantsCount =
                participantsService.countParticipantsByEventId(eventId);

        int availableTickets =
                ticketService.countAvailableTicketsByEventId(eventId);

        System.out.println("\n=== EVENT STATISTICS ===");
        System.out.println("Participants: " + participantsCount);
        System.out.println("Available tickets: " + availableTickets);
    }



}
