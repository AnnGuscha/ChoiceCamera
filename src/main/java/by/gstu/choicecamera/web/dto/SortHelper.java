package by.gstu.choicecamera.web.dto;

import by.gstu.choicecamera.domain.Camera;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortHelper {
    public static <T> List<T> order(String sortDirection, List<T> filtered, Comparator orderingFunction) {
        Collections.sort(filtered, orderingFunction);
        if (sortDirection.equals("desc"))
            Collections.reverse(filtered);
        return filtered;
    }

    public static List<Camera> sort(List<Camera> cameraList) {
        return cameraList.stream().sorted((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).collect(Collectors.toList());
    }

    public static List<Camera> search(List<Camera> cameraList, String sSearch) {
        return cameraList.stream().filter(c -> c.getName().toLowerCase().contains(sSearch.toLowerCase())
                || c.getManufacturer().toLowerCase().contains(sSearch.toLowerCase())).collect(Collectors.toList());
    }
}
