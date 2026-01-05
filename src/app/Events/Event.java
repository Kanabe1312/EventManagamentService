package app.Events;

public class Event {

    public int id;
    public String name;
    public String type;
    public String date;
    public String location;

    public String descriptionEvent() {
        String s = "";
        s += "Event ID: " + id + "\n";
        s += "Name: " + name + "\n";
        s += "Type: " + type + "\n";
        s += "Date: " + date + "\n";
        s += "Location: " + location + "\n";
        return s;
    }
}
