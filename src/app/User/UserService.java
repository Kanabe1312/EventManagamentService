package app.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserService {

    public List<User> users = new ArrayList<>();

    public void loadUsers() {

        User u1 = new User();
        u1.id = 1;
        u1.email = "andrei@gmail.com";
        u1.fullName = "Andrei Popescu";

        User u2 = new User();
        u2.id = 2;
        u2.email = "maria@gmail.com";
        u2.fullName = "Maria Ionescu";

        User u3 = new User();
        u3.id = 3;
        u3.email = "alex@gmail.com";
        u3.fullName = "Alex Dumitru";

        users.add(u1);
        users.add(u2);
        users.add(u3);
    }

    public User getUserById(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).id == id) {
                return users.get(i);
            }
        }
        return null;
    }

    public User getUserByEmail(String email) {
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if (u.email != null && u.email.equals(email)) {
                return u;
            }
        }
        return null;
    }

    public User addUser(User u) {
        u.id = generateId();
        users.add(u);
        return u;
    }

    private int generateId() {
        Random r = new Random();
        return r.nextInt(99999) + 1;
    }
}
