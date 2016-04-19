package by.gstu.choicecamera.service;

import by.gstu.choicecamera.domain.Camera;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cameraService")
@Transactional
public interface CameraService {

    void addCamera(Camera camera);

    List<Camera> listCamera();

    void removeCamera(Integer id);

    Camera getCamera(Integer id);

    void editCamera(Camera camera);
}
