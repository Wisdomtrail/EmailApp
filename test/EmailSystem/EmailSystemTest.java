package EmailSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailSystemTest {

    EmailSystem emailSystem;
    User sunday;
    User alice;
    Email email;

    @BeforeEach
    public void setUp(){

        emailSystem = new EmailSystem();
        sunday = new User("sunday", "sunday@gmail.com");
        alice = new User("Alice", "alice@gmail.com");
        emailSystem.addUser(alice);
    }
    @Test
    void addUser() {
        emailSystem.addUser(sunday);
        assertEquals(sunday, emailSystem.getUserByEmail("sunday@gmail.com"));
    }

    @Test
    void getUserByEmail() {
        assertEquals(alice, emailSystem.getUserByEmail("alice@gmail.com"));
    }

    @Test
    void sendEmail() {
        emailSystem.sendEmail(sunday.getEmail(),alice.getEmail(),
                "hello alice", "how was your day");
        List<Email> inbox = alice.getInbox();
        assertEquals("how was your day",inbox.get(0).getBody());
    }
}