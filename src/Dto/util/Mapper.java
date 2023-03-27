package Dto.util;

import Dto.Request.EmailRequest;
import Dto.Request.CreateUserRequest;
import Dto.response.EmailResponse;
import Dto.response.UserResponse;
import data.models.Email;
import data.models.User;

public class Mapper {

    public static void mapUser(User user, CreateUserRequest request){
        user.setFirstName(request.getFirstName());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setId(request.getId());

    }

    public static boolean isValidEmail(String email) {
        String regex = "^[a-z0-9+_.-]+@([gmail]+\\.)+[com]{2,}$";
        return email.matches(regex);
    }


    public static void mapEmail(Email email,EmailRequest request) {
        request.setTimestamp();
        email.setBody(request.getBody());
        email.setSubject(request.getSubject());
        email.setTimestamp(request.getTimestamp());
        email.setId(request.getId());

    }

    public static void mapUserRequestWithUserResponse(CreateUserRequest createUserRequest, UserResponse response){
        response.setFullName(createUserRequest.getFirstName()+" "+createUserRequest.getLastName());
        response.setEmail(createUserRequest.getEmail());
        response.setPhoneNumber(createUserRequest.getPhoneNumber());
        response.setId(createUserRequest.getId());
    }

    public static void mapEmailRequestWithResponse(EmailRequest emailRequest, EmailResponse response) {
        response.setEmail(emailRequest.getEmail());
        response.setBody(emailRequest.getBody());
        response.setSubject(emailRequest.getSubject());
        response.setId(emailRequest.getId());
        response.setDate(emailRequest.getTimestamp());
    }
}
