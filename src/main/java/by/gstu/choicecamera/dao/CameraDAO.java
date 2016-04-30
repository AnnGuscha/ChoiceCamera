package by.gstu.choicecamera.dao;

import by.gstu.choicecamera.domain.Camera;

import java.util.List;

public interface CameraDAO {

	void add(Camera camera);

	List<Camera> list();

	void remove(Integer id);

	Camera get(Integer id);

	void edit(Camera camera);
}