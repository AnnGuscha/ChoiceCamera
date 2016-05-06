package by.gstu.choicecamera.domain.compare;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.domain.optimization.MultiCriterion;

import java.util.Comparator;

public class ApertureCompare implements Comparator<Camera> {
    @Override
    public int compare(Camera o1, Camera o2) {
        double cam1 = (MultiCriterion.harrington(o1.getApertureMin()) + MultiCriterion.harrington(o1.getApertureMax())) / 2;
        double cam2 = (MultiCriterion.harrington(o2.getApertureMin()) + MultiCriterion.harrington(o2.getApertureMax())) / 2;
        if (cam1 > cam2)
            return 1;
        if (cam1 < cam2)
            return -1;
        return 0;
    }
}
