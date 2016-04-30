package by.gstu.choicecamera.dao;

import by.gstu.choicecamera.domain.User;

import java.util.List;

public interface UserDAO {

	void add(User user);

	List<User> list();

	void remove(Integer id);

	User get(Integer id);

	void edit(User user);
}