package data.repository;

import Dto.Request.CreateUserRequest;
import Dto.util.Mapper;
import data.models.User;

import java.util.ArrayList;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository{

    ArrayList<User> users = new ArrayList<>();
    int count = 0;

    @Override
    public User addUser(User user, CreateUserRequest userRequest) {
        if (userIsNotSaved(user) == null) {
            userRequest.setId(generateId());
            Mapper.mapUser(user,userRequest);
            users.add(user);
            count+=1;
        }
        return user;
    }


    private User userIsNotSaved(User user) {
        for (User user1 : users){
            if (user.getId() == user1.getId()){
                return user;
            }
        }
        return null;
    }

    @Override
    public int generateId() {
        return count+1;
    }


    @Override
    public User findById(int id) {
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                users.remove(user);
                break;
            }
            throw new IllegalArgumentException();
        }
    }


    @Override
    public int countUsers(){
       return users.size();
    }

    @Override
    public User findByEmail(String email) {
        for (User user : users) {
            if (Objects.equals(user.getEmail(), email)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public Object findByLastName(String lastName) {
        for (User user : users){
            if (Objects.equals(user.getLastName(), lastName)){
                return user;
            }
        }
        return null;
    }
}
