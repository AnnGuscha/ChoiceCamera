package by.gstu.choicecamera.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Expert")
public class Expert implements Serializable {

    private static final long serialVersionUID = 0;

    @Id
    @Column(name = "Id")
    @GeneratedValue
    private Integer id;

    @Column(name = "User")
    private Integer user;

    @Column(name = "Name")
    private String name;

    @Column(name = "MarkPrice")
    private Double markPrice;

    @Column(name = "MarkDate")
    private Double markDate;

    @Column(name = "MarkManufacturer")
    private Double markManufacturer;

    @Column(name = "MarkAperture")
    private Double markAperture;

    @Column(name = "MarkMatrixDot")
    private Double markMatrixDot;

    @Column(name = "ManufacturersMarks")
    private String manufacturersMarks;

    public Expert() {
    }

    public Expert(Integer user, String name, Double markPrice, Double markDate, Double markManufacturer, Double markAperture, Double markMatrixDot, String manufacturersMarks) {
        this.user = user;
        this.name = name;
        this.markPrice = markPrice;
        this.markDate = markDate;
        this.markManufacturer = markManufacturer;
        this.markAperture = markAperture;
        this.markMatrixDot = markMatrixDot;
        this.manufacturersMarks = manufacturersMarks;
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

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarkPrice() {
        return markPrice;
    }

    public void setMarkPrice(Double markPrice) {
        this.markPrice = markPrice;
    }

    public Double getMarkDate() {
        return markDate;
    }

    public void setMarkDate(Double markDate) {
        this.markDate = markDate;
    }

    public Double getMarkManufacturer() {
        return markManufacturer;
    }

    public void setMarkManufacturer(Double markManufacturer) {
        this.markManufacturer = markManufacturer;
    }

    public Double getMarkAperture() {
        return markAperture;
    }

    public void setMarkAperture(Double markAperture) {
        this.markAperture = markAperture;
    }

    public Double getMarkMatrixDot() {
        return markMatrixDot;
    }

    public void setMarkMatrixDot(Double markMatrixDot) {
        this.markMatrixDot = markMatrixDot;
    }

    public String getManufacturersMarks() {
        return manufacturersMarks;
    }

    public void setManufacturersMarks(String manufacturersMarks) {
        this.manufacturersMarks = manufacturersMarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expert)) return false;
        Expert expert = (Expert) o;
        return Objects.equals(getId(), expert.getId()) &&
                Objects.equals(getUser(), expert.getUser()) &&
                Objects.equals(getName(), expert.getName()) &&
                Objects.equals(getMarkPrice(), expert.getMarkPrice()) &&
                Objects.equals(getMarkDate(), expert.getMarkDate()) &&
                Objects.equals(getMarkManufacturer(), expert.getMarkManufacturer()) &&
                Objects.equals(getMarkAperture(), expert.getMarkAperture()) &&
                Objects.equals(getMarkMatrixDot(), expert.getMarkMatrixDot()) &&
                Objects.equals(getManufacturersMarks(), expert.getManufacturersMarks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getName(), getMarkPrice(), getMarkDate(), getMarkManufacturer(), getMarkAperture(), getMarkMatrixDot(), getManufacturersMarks());
    }

    //    public Double[] getManufacturersMarksDouble() {
//        String[] marksString = manufacturersMarks.split(" ");
//        Double[] marks = new Double[marksString.length];
//        for (int i = 0; i < marks.length; i++) {
//            marks[i] = Double.parseDouble(marksString[i]);
//        }
//        return marks;
//    }

//    public void setManufacturersMarks(Double[] marksDouble) {
//        String res = "";
//        for (Double mark : marksDouble) {
//            res += mark + " ";
//        }
//        this.manufacturersMarks = res.isEmpty() == true ? res : res.substring(0, res.length() - 1);
//    }
//
//    public void setMarks(Double[] marksDouble) {
//        if (marksDouble.length >= 5) {
//            this.setMarkPrice(marksDouble[0]);
//            this.setMarkDate(marksDouble[1]);
//            this.setMarkManufacturer(marksDouble[2]);
//            this.setMarkAperture(marksDouble[3]);
//            this.setMarkMatrixDot(marksDouble[4]);
//        }
//    }
//
//    public Double[] getMarks()
//    {
//        return new Double[]{this.getMarkPrice(),this.getMarkDate(),this.getMarkManufacturer(),this.getMarkAperture(),this.getMarkMatrixDot()};
//    }
}
