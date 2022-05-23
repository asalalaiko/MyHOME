package by.asalalaiko.myhome.service.impl;

import by.asalalaiko.myhome.dto.User;
import by.asalalaiko.myhome.dto.UserRole;
import by.asalalaiko.myhome.repo.UserRepo;
import by.asalalaiko.myhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JPAUserService implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User getUser(Long id) {
        return userRepo.getById(id);
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepo.findByLogin(login);
    }

    @Override
    public boolean addUser(User user) {
        User userFromDb = userRepo.findByLogin(user.getLogin());

        if (userFromDb != null) {
            return false;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.MANAGER);


        saveUser(user);
        return true;

    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
