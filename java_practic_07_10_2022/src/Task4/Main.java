package Task4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Collections.addAll(users, new User("admin"), new User("student"));
        users.forEach(User::print);
    }

}
