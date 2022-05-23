package by.asalalaiko.myhome.repo;

import by.asalalaiko.myhome.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
