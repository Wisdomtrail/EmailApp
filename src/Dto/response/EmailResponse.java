package Dto.response;

import java.text.SimpleDateFormat;
import java.util.Date;

public class EmailResponse {



    private String body;
    private String email;
    private Date date;
    private String subject;
    private int id;

    public void setSubject(String subject){
        this.subject = subject;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }



    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getBody() {
        return body;
    }
    @Override
    public String toString(){
        return String.format("""
                         %s
                body: %s
                date: %s
                mail_Id: %d""", subject,body, date, id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date timestamp) {
        this.date = timestamp;
    }
}
