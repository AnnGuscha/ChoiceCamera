package by.gstu.choicecamera.domain;

public class ExpertExtended {

    private Integer id;
    private User user;
    private String name;
    private Double[] marks;

    public ExpertExtended() {
    }

    public ExpertExtended(Integer id, User user, String name, Double[] marks) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.marks = marks;
    }

    public ExpertExtended(Expert expert) {
        this.id = expert.getId();
        //this.user = expert.getUser();
        this.name = expert.getName();
        this.marks = new Double[]{expert.getMarkPrice(),expert.getMarkDate(),expert.getMarkManufacturer(),expert.getMarkAperture(),expert.getMarkMatrixDot()};
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double[] getMarks() {
        return marks;
    }

    public void setMarks(Double[] marks) {
        this.marks = marks;
    }
}
