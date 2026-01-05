package app.Events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventsService {

    public List<Event> events = new ArrayList<>();

    public void loadEvents() {

        Event e1 = new Event();
        e1.id = 1;
        e1.name = "Tech Conference Berlin";
        e1.type = "CONFERENCE";
        e1.date = "2026-02-10";
        e1.location = "Berlin";

        Event e2 = new Event();
        e2.id = 2;
        e2.name = "Music Festival Summer";
        e2.type = "CONCERT";
        e2.date = "2026-06-21";
        e2.location = "Hamburg";

        Event e3 = new Event();
        e3.id = 3;
        e3.name = "Startup Networking Night";
        e3.type = "MEETUP";
        e3.date = "2026-03-05";
        e3.location = "Munich";

        Event e4 = new Event();
        e4.id = 4;
        e4.name = "Football Cup Final";
        e4.type = "SPORT";
        e4.date = "2026-05-18";
        e4.location = "Dortmund";

        events.add(e1);
        events.add(e2);
        events.add(e3);
        events.add(e4);
    }

    public Event getEventById(int id) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).id == id) {
                return events.get(i);
            }
        }
        return null;
    }

    public Event addEvent(Event e) {
        e.id = generateId();
        events.add(e);
        return e;
    }

    private int generateId() {
        Random r = new Random();
        return r.nextInt(99999) + 1;
    }
    public List<Event> getEventsByIds(List<Integer> ids) {
        List<Event> list = new ArrayList<>();

        for (int i = 0; i < events.size(); i++) {
            if (ids.contains(events.get(i).id)) {
                list.add(events.get(i));
            }
        }
        return list;
    }

}
