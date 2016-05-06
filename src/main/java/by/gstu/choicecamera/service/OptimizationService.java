package by.gstu.choicecamera.service;

import by.gstu.choicecamera.dao.CameraDAO;
import by.gstu.choicecamera.dao.ExpertDAO;
import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.domain.Expert;
import by.gstu.choicecamera.domain.optimization.MultiCriterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public List<Camera> listCameras() {
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
        return multiCriterion.solve(expertsMarks);
    }
}
