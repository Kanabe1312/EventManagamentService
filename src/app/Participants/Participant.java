package app.Participants;

public class Participant {

    public int id;
    public int eventId;
    public int userId;
    public String role;
    public int ticketId;
    public String descriptionParticipant() {
        String s = "";
        s += "Participant ID: " + id + "\n";
        s += "Event ID: " + eventId + "\n";
        s += "User ID: " + userId + "\n";
        s += "Role: " + role + "\n";
        return s;
    }
}
