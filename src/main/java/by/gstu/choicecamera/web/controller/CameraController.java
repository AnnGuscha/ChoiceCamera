package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class CameraController {

	@Autowired
	public CameraService cameraService;

	@RequestMapping("/index")
	public String listCameras(Map<String, Object> map) {

		map.put("camera", new Camera());
		map.put("cameraList", cameraService.listCamera());

		return "camera";
	}
	
	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addCamera(@ModelAttribute("camera") Camera camera,
			BindingResult result) {

		cameraService.addCamera(camera);

		return "redirect:/index";
	}

	@RequestMapping("/delete/{cameraId}")
	public String deleteCamera(@PathVariable("cameraId") Integer cameraId) {

		cameraService.removeCamera(cameraId);

		return "redirect:/index";
	}

	@RequestMapping("/get/{cameraId}")
	public String getCamera(@PathVariable("cameraId") Integer cameraId, Map<String, Object> map) {

		map.put("camera", cameraService.getCamera(cameraId));

		return "camera";
	}

	@RequestMapping(value="/edit/{cameraId}", method = RequestMethod.POST)
	public String editCamera(@PathVariable("cameraId") Camera camera, Map<String, Object> map) {

		cameraService.editCamera(camera);

		map.put("camera", cameraService.getCamera(camera.getId()));

		return "camera";
	}
}
