package by.gstu.choicecamera.service;

import by.gstu.choicecamera.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public interface UserService {

    void add(User user);

    List<User> list();

    void remove(Integer id);

    User get(Integer id);

    void edit(User user);
}
