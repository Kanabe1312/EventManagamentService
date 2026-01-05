package app.User;

public class User {

    public int id;
    public String email;
    public String fullName;

    public String descriptionUser() {
        String s = "";
        s += "User ID: " + id + "\n";
        s += "Email: " + email + "\n";
        s += "Full name: " + fullName + "\n";
        return s;
    }
}
