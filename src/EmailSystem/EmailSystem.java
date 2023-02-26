package EmailSystem;

import java.util.ArrayList;

public class EmailSystem {
    private final ArrayList<User> users;

    public EmailSystem() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByEmail(String email)throws IllegalArgumentException {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public void sendEmail(String from, String to, String subject, String body) {
        User recipient = getUserByEmail(to);
        if (recipient != null) {
            Email email = new Email(from, to, subject, body);
            recipient.receiveEmail(email);
        }
    }
}
