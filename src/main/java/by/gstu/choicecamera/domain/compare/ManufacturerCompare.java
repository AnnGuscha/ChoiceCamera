package by.gstu.choicecamera.domain.compare;

import by.gstu.choicecamera.domain.Camera;
import by.gstu.choicecamera.domain.Manufacturers;

import java.util.Comparator;

public class ManufacturerCompare implements Comparator<Camera> {
    @Override
    public int compare(Camera o1, Camera o2) {
        int cam1 = Manufacturers.valueOf(o1.getManufacturer().toUpperCase()).getValue();
        int cam2 = Manufacturers.valueOf(o2.getManufacturer().toUpperCase()).getValue();
        if (cam1 < cam2)
            return -1;
        if (cam1 > cam2)
            return 1;
        return 0;
    }
}
