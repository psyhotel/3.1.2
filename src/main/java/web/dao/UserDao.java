package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    User findById(Long id);

    List<User> allUsers();

    User getUser(Long id);

    void createUsers(User user);

    void deleteUser(Long id);

    User updateUser(User user);
}
