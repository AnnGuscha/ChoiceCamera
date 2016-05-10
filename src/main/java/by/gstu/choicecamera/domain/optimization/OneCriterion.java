package by.gstu.choicecamera.domain.optimization;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.domain.compare.CostCompare;

import java.util.List;

public class OneCriterion {

    List<Camera> cameras;

    public OneCriterion(List<Camera> cameras) {
        this.cameras = cameras;
    }

    public List<Camera> getCamerasByPrice() {
        cameras.sort(new CostCompare());
        return cameras;
    }
}
