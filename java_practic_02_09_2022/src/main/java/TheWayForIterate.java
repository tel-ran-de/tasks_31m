import com.onlineshop.users.User;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class TheWayForIterate {


    public static void main(String[] args) {

        User user1 = new User("user1", "test@test.com", "rue Ford 3, Dusseldorf");
        User user2 = new User("user2", "test@test1.com", "12 rue Carmel, Luxembourg");

        List<User> users = Arrays.asList(
                user1, user2
        );

        // show user name
        for (User userFor : users) {
            System.out.println(userFor.getName());
        }

        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + " " + users.get(i).getName());
        }

        Iterator<User> iterator = users.iterator();
        int i2 = 1;
        while (iterator.hasNext()) {
            User u = iterator.next();
            System.out.println(i2 + " " + u.getName());
            i2++;
        }
    }
}
