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
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepo, RoleRepository roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findByUserName(String name) {
        return userRepo.findFirstByEmail(name);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        Role userRole = roleRepo.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepo.save(user);
    }

    @Override
    public void saveEditUser(User user, String userName) {
        User dbUser = userRepo.findFirstByEmail(userName);
   //     dbUser.setEmail(user.getEmail());
        dbUser.setFirstName(user.getFirstName());
        dbUser.setLastName(user.getLastName());
        userRepo.save(dbUser);
    }

    @Override
    public User findById(Long id) {
        return userRepo.findFirstById(id);
    }

    @Override
    public void changePassword(String userName, String oldPassword, String newPassword, String confirmPassword) throws IllegalArgumentException {
        User user = userRepo.findFirstByEmail(userName);
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException();
        }
        if (!newPassword.equals(confirmPassword) || newPassword.length() < 6) {
            throw new IllegalArgumentException();
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        userRepo.save(user);
    }
}