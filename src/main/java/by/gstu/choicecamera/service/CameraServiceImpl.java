package by.gstu.choicecamera.service;

import by.gstu.choicecamera.dao.CameraDAO;
import by.gstu.choicecamera.domain.Camera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    public CameraDAO cameraDAO;

    public CameraServiceImpl() {
    }

    @Transactional
    public void addCamera(Camera camera) {
        cameraDAO.addCamera(camera);
    }

    @Transactional
    public List<Camera> listCamera() {
        return cameraDAO.listCamera();
    }

    @Transactional
    public void removeCamera(Integer id) {
        cameraDAO.removeCamera(id);
    }

    @Transactional
    public Camera getCamera(Integer id) {
        return cameraDAO.getCamera(id);
    }

    @Transactional
    public void editCamera(Camera camera) {
        cameraDAO.editCamera(camera);
    }
}
