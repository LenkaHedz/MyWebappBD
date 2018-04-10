package ua.training.db;

import ua.training.dao.Car;
import ua.training.dao.Driver;

import java.sql.*;
import java.util.*;

public class SqlImpl {
    private Connection conn;

    public SqlImpl() throws SQLException {
        DBProperties prop = new DBProperties();
        //String driverName = "org.gjt.mm.mysql.Driver"; //для СКБД MySQL
        conn = (Connection) DriverManager.getConnection( prop.getUrl(), prop.getUser(), prop.getPassword() );
        Statement st = conn.createStatement();
       /*  conn.setAutoCommit(false);
        st.execute("drop TABLE if exists CAR");
        st.execute("drop TABLE if exists DRIVER");
        st.execute("drop TABLE if exists CARDRIVER");
        st.execute("CREATE TABLE Car (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, model VARCHAR(128) DEFAULT NULL,\n" +
                "manufacture VARCHAR(128) DEFAULT NULL)");

        st.execute("CREATE TABLE Driver(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(128) DEFAULT NULL, telephone VARCHAR(13) DEFAULT NULL)");

        st.execute("Create table CarDriver(Car_id INT not null, Driver_id INT not null)");

        st.execute("ALTER TABLE `mydb`.`cardriver` ADD CONSTRAINT `FK_CAR_ID` FOREIGN KEY (`Car_id`) REFERENCES `mydb`.`car` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION");
       ADD CONSTRAINT `FK_DRIVER_ID`
        FOREIGN KEY (`Driver_id`)
        REFERENCES `mydb`.`driver` (`id`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION;
        ADD UNIQUE INDEX `UN_DRIVER_CAR` (`Car_id` ASC, `Driver_id` ASC);

        Заполняем таблицу с машинами:
        insert into car(model, manufacture) values('Focus', 'Ford');
        insert into car(model, manufacture) values('Clio', 'Reno');
        insert into car(model, manufacture) values('Toledo', 'Seat');
        Заполняем таблицу с водителями:
        insert into driver(name, telephone) values('Ivan Popov', '+380665201477');
        insert into driver(name, telephone) values('Petr Sergienko', '+380503125896');
        insert into driver(name, telephone) values('Nina Apina', '+380936658815');
        insert into driver(name, telephone) values('David Orlov', '+380446178455');
        Заполняем связующую таблицу:
        insert into cardriver(Car_id, Driver_id) values(1, 2);
        insert into cardriver(Car_id, Driver_id) values(2, 1);
        Проверяем всязи:
        select *
                from cardriver cd
        left join car c on c.id = cd.Car_id
        left join driver d on d.id = cd.Driver_id;

              PreparedStatement prepQuery = conn.prepareStatement(
                "select * from student where group = ?" );
        prepQuery.setInt(1,1);
        ResultSet result = prepQuery.executeQuery();
        if( result.next() ){
            System.out.println( "Serial value for inserted record "+ result.toString() );
        }

        */
     conn.commit();
    }

    public List<Car> listCars() throws SQLException {
        List<Car> cars = new ArrayList<Car>();
        PreparedStatement prepQuery = conn.prepareStatement("select * from car" );
        ResultSet result = prepQuery.executeQuery();
        while(result.next()){
            Car car = new Car();
            cars.add(car);
            car.setId(result.getLong(1));
            car.setModel(result.getNString(2));
            car.setManufacture(result.getString(3));
        }
        return cars;
    }

    public List<Driver> listDrivers() throws SQLException {
        List<Driver> drivers = new ArrayList<Driver>();
        PreparedStatement prepQuery = conn.prepareStatement("select * from driver" );
        ResultSet result = prepQuery.executeQuery();
        while(result.next()){
            Driver driver = new Driver();
            drivers.add(driver);
            driver.setId(result.getLong(1));
            driver.setName(result.getNString(2));
            driver.setTelephone(result.getString(3));
        }
        return drivers;
    }


    public Map<Long, Long> listCarDriverId() throws SQLException {
        Map<Long, Long> cardriver = new HashMap<>();
        PreparedStatement prepQuery = conn.prepareStatement("select * from cardriver" );
        ResultSet result = prepQuery.executeQuery();
        while(result.next()){
            cardriver.put(result.getLong(1), result.getLong(2));
        }
        return cardriver;
    }


}
