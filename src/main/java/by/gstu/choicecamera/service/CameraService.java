package by.gstu.choicecamera.service;

import by.gstu.choicecamera.domain.Camera;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("cameraService")
@Transactional
public interface CameraService {

    void add(Camera camera);

    List<Camera> list();

    void remove(Integer id);

    Camera get(Integer id);

    void edit(Camera camera);
}
