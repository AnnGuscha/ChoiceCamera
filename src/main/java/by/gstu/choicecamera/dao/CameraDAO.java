package by.gstu.choicecamera.dao;

import by.gstu.choicecamera.domain.Camera;

import java.util.List;

public interface CameraDAO {

	void addCamera(Camera camera);

	List<Camera> listCamera();

	void removeCamera(Integer id);

	Camera getCamera(Integer id);

	void editCamera(Camera camera);
}