package by.asalalaiko.myhome.service.impl;

import by.asalalaiko.myhome.dto.User;
import by.asalalaiko.myhome.repo.UserRepo;
import by.asalalaiko.myhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JPAUserService implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public boolean addUser(User user) {
        return false;
    }
}
