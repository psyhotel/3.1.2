package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class ServiceUserImpl implements ServiceUser {
    @Autowired
    private UserDao userdao;

    @Override
    public User findById(Long id) {
        return userdao.findById(id);
    }

    @Override
    public List<User> allUsers() {
        return userdao.allUsers();
    }

    @Override
    public User getUser(Long id) {
        return userdao.getUser(id);
    }

    @Override
    public void createUser(User user) {
        userdao.createUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userdao.deleteUser(id);
    }

    @Override
    public void updateUser(User user) {
        userdao.updateUser(user);

    }

}