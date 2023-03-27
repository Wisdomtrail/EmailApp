package Controllers;

import Dto.Request.CreateUserRequest;
import Services.UserServices;
import Services.UserServicesImpl;
import data.models.User;

public class UserController {

    UserServices userServices = new UserServicesImpl();

    public void register(CreateUserRequest registerRequest){
        userServices.register(registerRequest);
    }
    public User findByEmail(String email){
       return userServices.findByEmail(email);
    }
    int countUsers(){
       return userServices.countUsers();
    }
    public void deleteUser(int id){
        userServices.deleteUser(id);
    }
    public String login(CreateUserRequest request){
        return userServices.login(request);
    }

   public User findById(int id, String lastName){
        if (userServices.findById(id) == null || userServices.findByLastName(lastName) == null){
            throw new IllegalArgumentException();
        }
        else return userServices.findById(id);
   }
}
