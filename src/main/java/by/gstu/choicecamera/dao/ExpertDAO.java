package by.gstu.choicecamera.dao;

import by.gstu.choicecamera.domain.Expert;
import by.gstu.choicecamera.domain.User;

import java.util.List;

public interface ExpertDAO {

	void add(Expert expert);

	List<Expert> list();

	void remove(Integer id);

	Expert get(Integer id);

	Expert get(User user);

	void edit(Expert expert);
}