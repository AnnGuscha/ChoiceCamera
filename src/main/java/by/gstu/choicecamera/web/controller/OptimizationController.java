package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.service.OptimizationService;
import by.gstu.choicecamera.web.dto.JQueryDataTableParamModel;
import by.gstu.choicecamera.web.dto.JsonDTO;
import by.gstu.choicecamera.web.dto.SortHelper;
import by.gstu.choicecamera.web.model.CameraModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class OptimizationController {

    @Autowired
    public OptimizationService optimizationService;

    @RequestMapping("/best")
    public String listCameras() {

        return "cameras/bestCameras";
    }

    @RequestMapping("/bestbyprice")
    public String listCamerasByprice() {

        return "cameras/bestCamerasByPrice";
    }

    @RequestMapping(value = "/best/api", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getAll(JQueryDataTableParamModel param) {

        List<CameraModel> cameraList = optimizationService.listCameraModels();

        return getJsonDTO(param, cameraList);
    }

    private JsonDTO getJsonDTO(JQueryDataTableParamModel param, List<CameraModel> cameraList) {

        int iTotalRecords = cameraList.size();

        //Search
        if (param.getsSearch() != null) {
            cameraList = (List<CameraModel>) SortHelper.search(cameraList, param.getsSearch());
        }

        //Sorting
        int sortColumnIndex = param.getiSortCol_0();
        String sortDirection = param.getsSortDir_0();
        switch (sortColumnIndex) {
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

        //Pagination
        List<CameraModel> result = cameraList.stream().skip(param.getiDisplayStart()).limit(param.getiDisplayLength()).collect(Collectors.toList());

        return new JsonDTO(param.getsEcho(), iTotalRecords, cameraList.size(), result);
    }

    @RequestMapping(value = "/bestbyprice/api", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getByPrice(JQueryDataTableParamModel param) {

        List<CameraModel> cameraList = optimizationService.listCameraModelsByPrice();

        return getJsonDTO(param, cameraList);
    }
}
