package Controllers;

import Dto.Request.EmailRequest;
import Services.EmailServices;
import Services.EmailServicesImpl;
import data.models.User;

public class EmailController {

    private final EmailServices emailServices = new EmailServicesImpl();


    public String sendMail(EmailRequest request){
       return emailServices.sendMail(request);
    }
    public String checkMail(int id){
       return emailServices.checkMail(id);
    }
    public void deleteMail(int id){
        emailServices.deleteMail(id);
    }
    public int mailSize(){
        return emailServices.mailSize();
    }
}