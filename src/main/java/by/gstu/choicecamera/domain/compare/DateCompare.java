package by.gstu.choicecamera.domain.compare;

import by.gstu.choicecamera.domain.Camera;

import java.util.Comparator;

/**
 * Created by Anna on 4/6/2016.
 */
public class DateCompare implements Comparator<Camera> {

    @Override
    public int compare(Camera cam1, Camera cam2) {
        if(cam1.getReleaseDate()>cam2.getReleaseDate())
            return 1;
        if (cam1.getReleaseDate() < cam2.getReleaseDate())
            return -1;
        return 0;
    }
}

