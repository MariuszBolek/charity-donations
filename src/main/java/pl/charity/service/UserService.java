package pl.charity.service;


import pl.charity.entity.User;

import java.util.List;

public interface UserService {

    User findByUserName(String name);

    List<User> findAll();

    void saveUser(User user);

    void saveEditUser(User user);

    void saveEditUser(User user, String userName);

    void delete(Long id);

    User findById(Long id);

    void changePassword(String userName, String oldPassword, String newPassword, String confirmPassword);
}
