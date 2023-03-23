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
    EmailResponse response = new EmailResponse();

    @Override
    public String sendMail(EmailRequest request) {
        Email email = new Email();
        repository.addEmail(email,request);
        Mapper.mapEmailRequestWithResponse(request,response);
        return response.toString();
    }

    @Override
    public String checkMail(int id) {
        Email email = repository.findById(id);
        Mapper.mapEmailWithResponse(email,response);
        return response.toString();
    }

    @Override
    public void deleteMail(int id) {
        repository.deleteMail(id);
    }

    @Override
    public int mailSize() {
        return repository.countMails();
    }
}