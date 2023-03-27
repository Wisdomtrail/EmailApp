package data.repository;

import Dto.Request.CreateUserRequest;
import data.models.User;

public interface UserRepository {
    User addUser(User user, CreateUserRequest request);

    User findById(int id);

    void deleteUserById(int id);

    int generateId();

    int countUsers();

    User findByEmail(String email);

    Object findByLastName(String lastName);
}