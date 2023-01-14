package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface ServiceUser {
    Optional<User> findById(Long id);

    List<User> allUsers();

    Optional<User> getUser(Long id);

    void createUser(User user);

    void deleteUser(Long id);

    User updateUser(User user);
}