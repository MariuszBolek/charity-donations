package pl.charity.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.charity.entity.Role;
import pl.charity.entity.User;
import pl.charity.repository.RoleRepository;
import pl.charity.repository.UserRepository;
import pl.charity.service.UserService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public User findFirstById(Long id) {
        return null;
    }

    @Override
    public User findFirstByEmail(String email) {
        return null;
    }

    @Override
    public List<User> findAllByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<User> findAllByLastName(String lastName) {
        return null;
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(true);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void editUser(User user, Long id) {
            User userFromDB = userRepository.findFirstById(id);
            userFromDB.setFirstName(user.getFirstName());
            userFromDB.setLastName(user.getLastName());
            userRepository.save(user);
    }

    @Override
    public void changepassword(Long userId, String prevPassword, String newPassword, String confirmNewPassword) {

        User user = userRepository.findFirstById(userId);

        if (!passwordEncoder.matches(prevPassword, user.getPassword())) {
            throw new IllegalArgumentException();
        }
        if (!newPassword.equals(confirmNewPassword) || newPassword.length() < 6) {
            throw new IllegalArgumentException();
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {

    }
}
