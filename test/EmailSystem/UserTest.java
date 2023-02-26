package EmailSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    Email email;
    @BeforeEach
    public void setUp(){
        user = new User("sunday", "sunday@gmail.com");
        email = new Email("sunday@gmail.com", "alice@gmail.com", "hello alice", "how are you");
    }

    @Test
    void getNameTest() {
        String name = user.getName();
        assertEquals("sunday", name);
    }

    @Test
    void getEmailTest() {
        String mail = user.getEmail();
        assertEquals("sunday@gmail.com", mail);
    }

    @Test
    void receiveEmailTest() {
        user.receiveEmail(email);
        List<Email> inbox = user.getInbox();
        assertEquals("hello alice",email.getSubject());
        assertEquals(1,inbox.size());
        String sender = email.getFrom();
        assertEquals("sunday@gmail.com", sender);
    }

}