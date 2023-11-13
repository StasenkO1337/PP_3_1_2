package sprint.test.dao;


import sprint.test.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserById(Long id);
    void addUser(User user);
    void deleteUser(Long id);
    void updateUser(User user);
}
