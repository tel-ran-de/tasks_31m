import com.onlineshop.users.User;

import java.util.*;

public class UsersValidation {

    public List<User> getUsers() {
        User user1 = new User("user1", "test@test.com", "rue Ford 3, Dusseldorf");
        User user2 = new User("user2", "test.test1.com", "12 rue Carmel, Luxembourg");

        return Arrays.asList(
                user1, user2
        );
    }

    public String validateAndGetError(List<User> users) {
        StringBuilder builder = new StringBuilder();
        for(User user: users) {
            if(!user.getEmail().contains("@")) {
                builder.append(user.getName()).append(",");
            }
        }
        String result = builder.toString();
        if(result.isEmpty()) {
            return "";
        } else {
            return "Wrong email for users: " + result.substring(0, result.length() - 1);
        }
    }

    public static void main(String[] args) {
        UsersValidation test = new UsersValidation();
        List<User> users = test.getUsers();
        String error = test.validateAndGetError(users);
        System.out.println(error);
    }


}
