package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.service.CameraService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    private static final Logger log = Logger.getLogger(MainController.class);

    @Autowired
    public CameraService cameraService;


//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public Camera get(@PathVariable("id") Integer id) {
//
//        Camera camera = cameraService.getCamera(id);
//
//        return camera;
//    }
//
//    @RequestMapping(value = "/", method = RequestMethod.PUT)
//    public ModelAndView add(@ModelAttribute("camera") Camera camera,
//                                  BindingResult result) {
//
//        cameraService.addCamera(camera);
//
//        return new ModelAndView("details","camera",camera);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
//    public String edit(@PathVariable("id") Camera camera, Map<String, Object> map) {
//
//        cameraService.editCamera(camera);
//
//        map.put("camera", cameraService.getCamera(camera.getId()));
//
//        return "camera";
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable("id") Integer cameraId) {
//
//        cameraService.removeCamera(cameraId);
//
//        return "redirect:/index";
//    }
}
