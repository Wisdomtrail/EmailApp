package EmailSystem;
// Email.java

import java.util.Date;

public class Email {
    private final String from;
    private final String to;
    private final String subject;
    private final String body;
    private final Date timestamp;

    public Email(String from, String to, String subject, String body) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.timestamp = new Date();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}