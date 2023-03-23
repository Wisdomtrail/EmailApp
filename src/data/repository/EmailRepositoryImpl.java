package data.repository;

import Dto.Request.EmailRequest;
import Dto.util.Mapper;
import data.models.Email;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmailRepositoryImpl implements EmailRepository{

    ArrayList<Email> emails = new ArrayList<>();
    private int count;

    @Override
    public void addEmail(Email email, EmailRequest request) {
        request.setId(generateId());
        Mapper.mapEmail(email, request);
        emails.add(email);
        count++;
    }

    private int generateId() {
        return count+1;
    }


    @Override
    public void deleteMail(int id) {
        emails.remove(id-1);
        count--;
    }

    @Override
    public Email getEmail(int id) {
        return emails.get(id-1);
    }

    @Override
    public int countMails() {
        return emails.size();
    }


    @Override
    public Email findById(int id) {
        for (Email email : emails){
            if (id == email.getId()){
                return email;
            }
        }
        return null;
    }

    @Override
    public List<Email> findAll() {
        return emails;
    }

    @Override
    public Email getMailWithSubject(String subject) {
        for (Email email : emails){
            if (Objects.equals(email.getSubject(), subject)){

            }
        }
        return null;
    }

}
