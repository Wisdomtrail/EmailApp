package data.models;

import java.util.Date;

public class Email {
    private String subject;
    private String body;
    private Date timestamp;
    private String email;
    private int Id;

    public Date getTimestamp() {
        return timestamp;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int id) {
        this.Id = id;
    }


    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }



    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
    