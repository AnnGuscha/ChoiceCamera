package by.gstu.choicecamera.domain;

public class CameraWithMarks implements Comparable {
    public Camera camera;
    public double[] marks;
    public double indicImpot;

    public CameraWithMarks() {
    }

    public CameraWithMarks(Camera camera, double[] marks) {
        this.camera = camera;
        this.marks = marks;
        indicImpot = 0;
    }

    @Override
    public int compareTo(Object obj) {
        CameraWithMarks cam = (CameraWithMarks) obj;
        if (this.indicImpot < cam.indicImpot)
            return -1;
        if (this.indicImpot > cam.indicImpot)
            return 1;
        return 0;
    }
}
