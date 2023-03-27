package Services;

import Dto.Request.CreateUserRequest;
import data.models.User;

public interface UserServices {
    void register(CreateUserRequest registerRequest);
    User findByEmail(String email);
    int countUsers();
    void deleteUser(int id);
    String login(CreateUserRequest request);
    User findById(int id);

    Object findByLastName(String lasName);
}
