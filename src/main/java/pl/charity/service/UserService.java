package pl.charity.service;


import pl.charity.entity.User;

import java.util.List;

public interface UserService {

    User findByUserName(String name);

    void saveUser(User user);

    void saveEditUser(User user, Long id);

    User findById(Long id);

    void changePassword(Long userId, String oldPassword, String newPassword, String confirmPassword);
}
