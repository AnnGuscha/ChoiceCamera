package by.gstu.choicecamera.web.model;

import by.gstu.choicecamera.domain.Camera;

public class CameraModel extends Camera {

    private String color;

    public CameraModel(String name, Integer price, Integer releaseDate, String manufacturer, Double apertureMin, Double apertureMax, Double matrixDot, String color) {
        super(name, price, releaseDate, manufacturer, apertureMin, apertureMax, matrixDot);
        this.color = color;
    }

    public CameraModel(String name, Integer price, Integer releaseDate, String manufacturer, Double apertureMin, Double apertureMax, Double matrixDot) {
        super(name, price, releaseDate, manufacturer, apertureMin, apertureMax, matrixDot);
    }

    public CameraModel(Camera camera) {
        super(camera.getName(), camera.getPrice(), camera.getReleaseDate(), camera.getManufacturer(), camera.getApertureMin(), camera.getApertureMax(), camera.getMatrixDot());
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
