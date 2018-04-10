package ua.training.dao;

import java.util.List;
import java.util.Map;

public interface CarDriverDao {
    List<Car> getListCars();
    List<Driver> getListDrivers();
    Map<Car, Driver> getListCarDriver();
    Car getCarById(Long carId);
    Driver getDriverById(Long driverId);
    Car getCarByDriver(Driver driver);
    Driver getDriverByCar(Car car);
}
