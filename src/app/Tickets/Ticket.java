package app.Tickets;

public class Ticket {

    public int id;
    public int eventId;
    public double price;
    public String date;
    public int quantity;


    public String descriptionTicket() {
        String s = "";
        s += "Ticket ID: " + id + "\n";
        s += "Event ID: " + eventId + "\n";
        s += "Price: " + price + "\n";
        s+= "Date: "  + date    +"\n";
        return s;
    }
}
