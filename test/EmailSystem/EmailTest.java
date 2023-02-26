package EmailSystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    Email email;

    @BeforeEach
    public void setUp(){
        email = new Email("sunday", "alice", "hello babe", "how are you");

    }

    @Test
    void getFrom() {
        assertEquals("sunday", email.getFrom());
    }

    @Test
    void getTo() {
        assertEquals("alice", email.getTo());
    }

    @Test
    void getSubject() {
        assertEquals("hello babe", email.getSubject());
    }

    @Test
    void getBody() {
        assertEquals("how are you", email.getBody());
    }

    @Test
    void getTimestamp() {
        Date timeStamp = email.getTimestamp();
        assertEquals(new Date().getTime(),timeStamp.getTime(),1000);
    }
}