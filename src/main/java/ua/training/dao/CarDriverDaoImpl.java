package ua.training.dao;

import ua.training.db.SqlImpl;

import java.sql.SQLException;
import java.util.*;

public class CarDriverDaoImpl implements CarDriverDao {
    private SqlImpl sql;
    private List<Car> listCars;
    private List<Driver> listDrivers;
    private Map<Car, Driver> listCarDriver;

    public CarDriverDaoImpl() {
        try {
            sql = new SqlImpl();
            listCars = sql.listCars();
            listDrivers = sql.listDrivers();
            Map<Long, Long> listId = sql.listCarDriverId();
            listId.forEach((k, v) -> listCarDriver.put(this.getCarById(k), this.getDriverById(v)));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Car> getListCars() {
        return listCars;
    }

    @Override
    public List<Driver> getListDrivers() {
        return listDrivers;
    }

    @Override
    public Map<Car, Driver> getListCarDriver() {
        return listCarDriver;
    }

    @Override
    public Car getCarById(Long carId) {
        for (Car car : listCars) {
            if(carId.compareTo(car.getId()) == 0){
                return car;
            }
        }
        return null;
    }

    @Override
    public Driver getDriverById(Long driverId) {
        for (Driver driver : listDrivers) {
            if(driverId.compareTo(driver.getId()) == 0){
                return driver;
            }
        }
        return null;
    }

    @Override
    public Car getCarByDriver(Driver driver) {
        for (Car car : listCarDriver.keySet()) {
            if (listCarDriver.get(car).equals(driver)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Driver getDriverByCar(Car car) {
        return listCarDriver.get(car);
    }

}
