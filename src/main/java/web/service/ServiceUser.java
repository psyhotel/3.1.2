package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;


public interface ServiceUser {
    User findById(Long id);

    List<User> allUsers();

    User getUser(Long id);

    void createUsers(User user);

    void deleteUser(Long id);

    void updateUser(User user);

}
