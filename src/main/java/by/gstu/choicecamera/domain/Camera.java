package by.gstu.choicecamera.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Camera")
public class Camera implements Serializable {

    private static final long serialVersionUID=0;

    @Id
    @Column(name="Id")
    @GeneratedValue
    private Integer id;

    @Column(name="Name")
    private String name;

    @Column(name="Price")
    private Integer price;

    @Column(name="ReleaseDate")
    private Integer releaseDate;

    @Column(name="Manufacturer")
    private String manufacturer;

    @Column(name="ApertureMin")
    private Double apertureMin;

    @Column(name="ApertureMax")
    private Double apertureMax;

    @Column(name="MatrixDot")
    private Double matrixDot;

    public Camera() {
    }

    public Camera(String name, Integer price, Integer releaseDate, String manufacturer, Double apertureMin, Double apertureMax, Double matrixDot) {
        this.name = name;
        this.price = price;
        this.releaseDate = releaseDate;
        this.manufacturer = manufacturer;
        this.apertureMin = apertureMin;
        this.apertureMax = apertureMax;
        this.matrixDot = matrixDot;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Integer releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Double getApertureMin() {
        return apertureMin;
    }

    public void setApertureMin(Double apertureMin) {
        this.apertureMin = apertureMin;
    }

    public Double getApertureMax() {
        return apertureMax;
    }

    public void setApertureMax(Double apertureMax) {
        this.apertureMax = apertureMax;
    }

    public Double getMatrixDot() {
        return matrixDot;
    }

    public void setMatrixDot(Double matrixDot) {
        this.matrixDot = matrixDot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Camera)) return false;
        Camera camera = (Camera) o;
        return Objects.equals(getId(), camera.getId()) &&
                Objects.equals(getName(), camera.getName()) &&
                Objects.equals(getPrice(), camera.getPrice()) &&
                Objects.equals(getReleaseDate(), camera.getReleaseDate()) &&
                Objects.equals(getManufacturer(), camera.getManufacturer()) &&
                Objects.equals(getApertureMin(), camera.getApertureMin()) &&
                Objects.equals(getApertureMax(), camera.getApertureMax()) &&
                Objects.equals(getMatrixDot(), camera.getMatrixDot());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice(), getReleaseDate(), getManufacturer(), getApertureMin(), getApertureMax(), getMatrixDot());
    }
}
