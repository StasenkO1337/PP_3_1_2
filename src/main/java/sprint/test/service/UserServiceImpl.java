package sprint.test.service;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sprint.test.dao.UserDao;
import sprint.test.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }


    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }


    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }


    @Transactional
    @Override
    public void updateUser(@Valid User user) {
        userDao.updateUser(user);
    }

}
