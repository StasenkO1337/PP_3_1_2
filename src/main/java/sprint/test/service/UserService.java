package sprint.test.service;


import jakarta.validation.Valid;
import sprint.test.model.User;


import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user);
    void updateUser(@Valid User user);
    void deleteUser(Long id);
}
