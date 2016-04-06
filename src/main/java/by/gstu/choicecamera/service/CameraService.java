package by.gstu.choicecamera.service;

import by.gstu.choicecamera.domain.Camera;
import java.util.List;

import javax.annotation.Resource;

import by.gstu.choicecamera.domain.Contact;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("cameraService")
@Transactional
public interface CameraService {

    public void addCamera(Camera camera);

    public List<Camera> listCamera();

    public void removeCamera(Integer id);

    public Camera getCamera(Integer id);

    public void editCamera(Camera camera);
}
