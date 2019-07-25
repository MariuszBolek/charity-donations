package pl.charity.service;


import pl.charity.entity.User;

import java.util.List;

public interface UserService {

    User findFirstById(Long id);

    User findFirstByEmail(String email);

    List<User> findAllByFirstName(String firstName);

    List<User> findAllByLastName(String lastName);

    User saveUser(User user);

    void deleteById(Long id);
}
