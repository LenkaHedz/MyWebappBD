# MyWebappBD

Создаем таблицы с машинами и водителями со связью многие ко многим

В MySQL консоли создаем схему и подключаемся к ней:
CREATE DATABASE mydb; 
USE mydb;

В MeSQL создаем таблицы и связи:
CREATE TABLE Car (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
model VARCHAR(128) DEFAULT NULL,
manufacture VARCHAR(128) DEFAULT NULL
);
CREATE TABLE Driver (
id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(128) DEFAULT NULL,
telephone VARCHAR(13) DEFAULT NULL
);

Create table CarDriver(
Car_id INT not null,
Driver_id INT not null);
ALTER TABLE `mydb`.`cardriver` 
ADD CONSTRAINT `FK_CAR_ID`
  FOREIGN KEY (`Car_id`)
  REFERENCES `mydb`.`car` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
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


