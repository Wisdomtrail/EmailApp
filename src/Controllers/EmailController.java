package Controllers;

import Dto.Request.EmailRequest;
import Services.EmailServices;
import Services.EmailServicesImpl;

public class EmailController {

    private final EmailServices emailServices = new EmailServicesImpl();


    public String sendMail(EmailRequest request){
       return emailServices.sendMail(request);
    }
    public String checkMail(int id){
       return emailServices.checkMail(id);
    }
    public void deleteMail(int id){
        try {
            emailServices.deleteMail(id);
        }
        catch (IndexOutOfBoundsException ignored){

        }

    }
    public int mailSize(){
        return emailServices.mailSize();
    }
}