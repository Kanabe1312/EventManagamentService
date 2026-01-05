package app.Participants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ParticipantsService {

    public List<Participant> participants = new ArrayList<>();

    public void loadParticipants() {

        Participant p1 = new Participant();
        p1.id = 1;
        p1.eventId = 1;
        p1.userId = 1;
        p1.role = "ATTENDEE";

        Participant p2 = new Participant();
        p2.id = 2;
        p2.eventId = 1;
        p2.userId = 2;
        p2.role = "ATTENDEE";

        Participant p3 = new Participant();
        p3.id = 3;
        p3.eventId = 2;
        p3.userId = 3;
        p3.role = "ORGANIZER";

        participants.add(p1);
        participants.add(p2);
        participants.add(p3);
    }

    public Participant getParticipantById(int id) {
        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).id == id) {
                return participants.get(i);
            }
        }
        return null;
    }

    public Participant addParticipant(Participant p) {
        p.id = generateId();
        participants.add(p);
        return p;
    }

    private int generateId() {
        Random r = new Random();
        return r.nextInt(99999) + 1;
    }

    public boolean isUserAlreadyParticipant(int eventId, int userId) {
        for (int i = 0; i < participants.size(); i++) {
            Participant p = participants.get(i);
            if (p.eventId == eventId && p.userId == userId) {
                return true;
            }
        }
        return false;
    }
    public boolean registerUserToEvent(int eventId, int userId, int ticketId) {

        if (isUserAlreadyParticipant(eventId, userId)) {
            return false;
        }

        Participant p = new Participant();
        p.eventId = eventId;
        p.userId = userId;
        p.role = "ATTENDEE";
        p.ticketId= ticketId;

        addParticipant(p);
        return true;
    }
    public List<Integer> getEventIdsByUserId(int userId) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).userId == userId) {
                list.add(participants.get(i).eventId);
            }
        }
        return list;
    }
    public List<Participant> getParticipantsByEventId(int eventId) {
        List<Participant> list = new ArrayList<>();

        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).eventId == eventId) {
                list.add(participants.get(i));
            }
        }
        return list;
    }
    public boolean cancelRegistration(int eventId, int userId) {

        for (int i = 0; i < participants.size(); i++) {
            Participant p = participants.get(i);

            if (p.eventId == eventId && p.userId == userId) {
                participants.remove(i);
                return true;
            }
        }
        return false;
    }
    public int countParticipantsByEventId(int eventId) {
        int count = 0;

        for (int i = 0; i < participants.size(); i++) {
            if (participants.get(i).eventId == eventId) {
                count++;
            }
        }
        return count;
    }




}
