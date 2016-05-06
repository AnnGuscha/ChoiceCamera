package by.gstu.choicecamera.domain.compare;

import by.gstu.choicecamera.domain.Camera;

import java.util.Comparator;

public class CostCompare implements Comparator<Camera> {

    @Override
    public int compare(Camera cam1, Camera cam2) {
        if(cam1.getPrice()>cam2.getPrice())
            return 1;
        if (cam1.getPrice() < cam2.getPrice())
            return -1;
        return 0;
    }
}
