package Services;

import Dto.Request.EmailRequest;
import Dto.response.EmailResponse;
import Dto.util.Mapper;
import data.models.Email;
import data.models.User;
import data.repository.EmailRepository;
import data.repository.EmailRepositoryImpl;

public class EmailServicesImpl implements EmailServices {


    EmailRepository repository = new EmailRepositoryImpl();

    @Override
    public String sendMail(EmailRequest request) {
        User user = new User();
        Email email = new Email();
        EmailResponse response = new EmailResponse();
        repository.addEmail(email, request);
        Mapper.mapEmailRequestWithResponse(request, response);
        user.setToInbox(email);
        return response.toString();
    }

    @Override
    public String checkMail(int id) {
        EmailResponse response = new EmailResponse();
       Email email =  user.getEmailInInbox(id);
       Mapper.mapEmailWithResponse(email, response);
       return response.toString();
    }

    @Override
    public void deleteMail(String subject) {

    }

    @Override
    public int mailSize() {
        return 0;
    }
}