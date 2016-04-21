package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.service.CameraService;
import by.gstu.choicecamera.web.dto.JQueryDataTableParamModel;
import by.gstu.choicecamera.web.dto.JsonDTO;
import by.gstu.choicecamera.web.dto.SortHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        int iTotalRecords = cameraList.size();

        //Sorting
        int sortColumnIndex = param.getiSortCol_0();
        cameraList = SortHelper.sort(cameraList);
        String sortDirection = param.getsSortDir_0();
        switch (sortColumnIndex) {
            case 0: {
                cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
                    @Override
                    public int compare(Camera o1, Camera o2) {
                        return Integer.compare(o1.getId(), o2.getId());
                    }
                });
//                cameraList.stream()
//                        .sorted((c1, c2) -> Integer.compare(c1.getId(), c2.getId()));
            }
            break;
            case 1: {
                cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
                    @Override
                    public int compare(Camera o1, Camera o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
            }
            break;
            case 2: {
                cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
                    @Override
                    public int compare(Camera o1, Camera o2) {
                        return Integer.compare(o1.getPrice(), o2.getPrice());
                    }
                });
            }
            break;
            case 3: {
                cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
                    @Override
                    public int compare(Camera o1, Camera o2) {
                        return Integer.compare(o1.getReleaseDate(), o2.getReleaseDate());
                    }
                });
            }
            break;
            case 4: {
                cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
                    @Override
                    public int compare(Camera o1, Camera o2) {
                        return o1.getManufacturer().compareTo(o2.getManufacturer());
                    }
                });
            }
            break;
            case 5: {
                cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
                    @Override
                    public int compare(Camera o1, Camera o2) {
                        return Double.compare(o1.getApertureMin(), o2.getApertureMin());
                    }
                });
            }
            break;
            case 6: {
                cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
                    @Override
                    public int compare(Camera o1, Camera o2) {
                        return Double.compare(o1.getApertureMax(), o2.getApertureMax());
                    }
                });
            }
            break;
            case 7: {
                cameraList = SortHelper.order(sortDirection, cameraList, new Comparator<Camera>() {
                    @Override
                    public int compare(Camera o1, Camera o2) {
                        return Double.compare(o1.getMatrixDot(), o2.getMatrixDot());
                    }
                });
            }
            break;
        }
//        if (sortDirection.equals("desc")) // asc or desc
//            Collections.reverse(cameraList);

        //Pagination
        List<Camera> result = cameraList.stream().skip(param.getiDisplayStart()).limit(param.getiDisplayLength()).collect(Collectors.toList());
        JsonDTO jsonDTO = new JsonDTO(param.getsEcho(), iTotalRecords, cameraList.size(), result);

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
