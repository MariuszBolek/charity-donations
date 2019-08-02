package pl.charity.service;


import pl.charity.entity.User;

import java.util.List;

public interface UserService {

    User findFirstById(Long id);

    User findFirstByEmail(String email);

    List<User> findAllByFirstName(String firstName);

    List<User> findAllByLastName(String lastName);

    void saveUser(User user);

    void editUser(User user, Long id);

    void changepassword(Long userId, String prevPassword, String newPassword, String confirmNewPassword);

    void deleteById(Long id);
}
