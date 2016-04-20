package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.service.CameraService;
import by.gstu.choicecamera.web.dto.JQueryDataTableParamModel;
import by.gstu.choicecamera.web.dto.JsonDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/camera")
public class MainController {
    private static final Logger log = Logger.getLogger(MainController.class);

    @Autowired
    public CameraService cameraService;

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    Object listCameras(JQueryDataTableParamModel param) {

        List<Camera> cameraList = cameraService.listCamera();

        int size = cameraList.size();

        JsonDTO jsonDTO = new JsonDTO(param.sEcho, size, size, cameraList);

        return jsonDTO;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Camera getCamera(@PathVariable("id") Integer id) {

        Camera camera = cameraService.getCamera(id);

        return camera;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public String addCamera(@ModelAttribute("camera") Camera camera,
                            BindingResult result) {

        cameraService.addCamera(camera);

        return "redirect:/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editCamera(@PathVariable("id") Camera camera, Map<String, Object> map) {

        cameraService.editCamera(camera);

        map.put("camera", cameraService.getCamera(camera.getId()));

        return "camera";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteCamera(@PathVariable("id") Integer cameraId) {

        cameraService.removeCamera(cameraId);

        return "redirect:/index";
    }
}
