package by.gstu.choicecamera.dao;

import by.gstu.choicecamera.domain.Camera;

import java.util.List;

public interface CameraDAO {

	public void addCamera(Camera camera);

	public List<Camera> listCamera();

	public void removeCamera(Integer id);

	public Camera getCamera(Integer id);

	public void editCamera(Camera camera);
}