package by.gstu.choicecamera.dao;

import by.gstu.choicecamera.domain.Expert;

import java.util.List;

public interface ExpertDAO {

	void add(Expert expert);

	List<Expert> list();

	void remove(Integer id);

	Expert get(Integer id);

	void edit(Expert expert);
}