package ua.training.dao;

public class Car {
    long id;
    String model;
    String manufacture;

    public Car() {
    }

    public Car(long id, String model, String manufacture) {
        this.id = id;
        this.model = model;
        this.manufacture = manufacture;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return "Car{" +
                //"id=" + id +
                ", model='" + model + '\'' +
                ", manufacture='" + manufacture + '\'' +
                '}';
    }
}
