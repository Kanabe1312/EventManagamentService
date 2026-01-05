package app.Tickets;

import java.util.ArrayList;
import java.util.List;

public class TicketService {
    public void loadTickets() {

        Ticket t1 = new Ticket();
        t1.id = 1;
        t1.eventId = 1;
        t1.price = 100;
        t1.date = "2026-02-10";

        Ticket t2 = new Ticket();
        t2.id = 2;
        t2.eventId = 2;
        t2.price = 150;
        t2.date = "2026-06-21";

        tickets.add(t1);
        tickets.add(t2);
    }


    public List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getTicketsByEventId(int eventId) {
        List<Ticket> list = new ArrayList<>();

        for (int i = 0; i < tickets.size(); i++) {
            if (tickets.get(i).eventId == eventId) {
                list.add(tickets.get(i));
            }
        }
        return list;
    }
    public List<Ticket> getTicketsForEvent(int eventId) {
        List<Ticket> result = new ArrayList<>();

        for (int i = 0; i < tickets.size(); i++) {
            Ticket t = tickets.get(i);
            if (t.eventId == eventId) {
                result.add(t);
            }
        }
        return result;
    }
    public int countAvailableTicketsByEventId(int eventId) {
        int total = 0;

        for (int i = 0; i < tickets.size(); i++) {
            Ticket t = tickets.get(i);
            if (t.eventId == eventId) {
                total += t.quantity;
            }
        }
        return total;
    }

}
