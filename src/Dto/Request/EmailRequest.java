package Dto.Request;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class EmailRequest {
    private String subject;
    private String body;
    private Date timestamp;
    private String email;
    private int Id;
    private String receiver;


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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
       this.timestamp = new Date();
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

    public void setReceiver(String recipientEMail) {
        this.receiver = recipientEMail;
    }

    public String getReceiver(){
        return receiver;
    }
}
