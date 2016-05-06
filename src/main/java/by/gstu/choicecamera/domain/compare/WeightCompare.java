package by.gstu.choicecamera.domain.compare;

import by.gstu.choicecamera.domain.CameraWithMarks;

import java.util.Comparator;

public class WeightCompare implements Comparator<CameraWithMarks> {

    @Override
    public int compare(CameraWithMarks cam1, CameraWithMarks cam2) {
        if (cam1.indicImpot < cam2.indicImpot)
            return -1;
        if (cam1.indicImpot > cam1.indicImpot)
            return 1;
        return 0;
    }
}
