package Services;

import Dto.Request.CreateUserRequest;
import Dto.response.UserResponse;
import Dto.util.Mapper;
import data.models.User;
import data.repository.UserRepository;
import data.repository.UserRepositoryImpl;

public class UserServicesImpl implements UserServices {
    UserRepository repository = new UserRepositoryImpl();


    @Override
    public void register(CreateUserRequest registerRequest) {
        User user = new User();
        repository.addUser(user, registerRequest);
    }

    @Override
    public String login(CreateUserRequest request){
        UserResponse response = new UserResponse();
        Mapper.mapUserRequestWithUserResponse(request,response);
        return response.toString();
    }

    @Override
    public User findById(int id) {
        return repository.findById(id);
    }

    @Override
    public Object findByLastName(String lastName) {
       return repository.findByLastName(lastName);
    }

    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public int countUsers() {
        return repository.countUsers();
    }

    @Override
    public void deleteUser(int id) {
        repository.deleteUserById(id);
    }
}
