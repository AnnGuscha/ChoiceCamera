package by.gstu.choicecamera.service;

import by.gstu.choicecamera.dao.CameraDAO;
import by.gstu.choicecamera.dao.ExpertDAO;
import by.gstu.choicecamera.domain.CameraWithMarks;
import by.gstu.choicecamera.domain.Expert;
import by.gstu.choicecamera.domain.optimization.MultiCriterion;
import by.gstu.choicecamera.web.model.CameraModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("optimizationService")
@Transactional
public class OptimizationService {

    @Autowired
    public CameraDAO cameraDAO;
    @Autowired
    public ExpertDAO expertDAO;

    public OptimizationService() {
    }

    @Transactional
    public List<CameraModel> listCameraModels() {

        MultiCriterion multiCriterion = new MultiCriterion(cameraDAO.list());
        List<Expert> experts = expertDAO.list();
        double[][] expertsMarks = new double[experts.size()][5];
        for (int i = 0; i < experts.size(); i++) {
            expertsMarks[i][0] = experts.get(i).getMarkPrice();
            expertsMarks[i][1] = experts.get(i).getMarkDate();
            expertsMarks[i][2] = experts.get(i).getMarkManufacturer();
            expertsMarks[i][3] = experts.get(i).getMarkAperture();
            expertsMarks[i][4] = experts.get(i).getMarkMatrixDot();
        }

        multiCriterion.solve(expertsMarks);


        List<CameraModel> cameraModels = new ArrayList<>();
        CameraModel curModel;
        List<CameraWithMarks> cameraWithMarksList = multiCriterion.getCamerasMarks();
        for (int i = 0; i < cameraWithMarksList.size(); i++) {
            CameraWithMarks cam = cameraWithMarksList.get(i);
            curModel = new CameraModel(cam.camera);
            if (cam.indicImpot == cameraWithMarksList.get(0).indicImpot)
                curModel.setColor("#98FB98");
            else if (i <= 2)
                curModel.setColor("#F0E68C");
            cameraModels.add(curModel);
        }
        return cameraModels;
    }
}
