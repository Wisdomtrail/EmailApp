package EmailSystem;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final String email;
    private final List<Email> inbox;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.inbox = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Email> getInbox() {
        return inbox;
    }

    public void receiveEmail(Email email) {
        inbox.add(email);
    }
}