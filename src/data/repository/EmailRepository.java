package data.repository;

import Dto.Request.EmailRequest;

import data.models.Email;

import java.util.List;

public interface EmailRepository {

    void addEmail(Email email, EmailRequest request);
    void deleteMail(int id);
    int countMails();
    Email findById(int i);
    List<Email> findAll();

    Email getMailWithSubject(String Subject);
}
