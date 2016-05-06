package by.gstu.choicecamera.web.controller;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.service.OptimizationService;
import by.gstu.choicecamera.web.dto.JQueryDataTableParamModel;
import by.gstu.choicecamera.web.dto.JsonDTO;
import by.gstu.choicecamera.web.dto.SortHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/best/api", method = RequestMethod.GET)
    public
    @ResponseBody
    Object getAll(JQueryDataTableParamModel param) {

        List<Camera> cameraList = optimizationService.listCameras();
        int iTotalRecords = cameraList.size();

        //Search
        if (param.getsSearch() != null) {
            cameraList = SortHelper.search(cameraList, param.getsSearch());
        }

        //Pagination
        List<Camera> result = cameraList.stream().skip(param.getiDisplayStart()).limit(param.getiDisplayLength()).collect(Collectors.toList());
        JsonDTO jsonDTO = new JsonDTO(param.getsEcho(), iTotalRecords, cameraList.size(), result);

        return jsonDTO;
    }

}
