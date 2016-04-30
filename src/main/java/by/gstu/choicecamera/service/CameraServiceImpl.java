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
    public void add(Camera camera) {
        cameraDAO.add(camera);
    }

    @Transactional
    public List<Camera> list() {
        return cameraDAO.list();
    }

    @Transactional
    public void remove(Integer id) {
        cameraDAO.remove(id);
    }

    @Transactional
    public Camera get(Integer id) {
        return cameraDAO.get(id);
    }

    @Transactional
    public void edit(Camera camera) {
        cameraDAO.edit(camera);
    }
}
