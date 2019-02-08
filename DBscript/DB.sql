CREATE TABLE `jdbcdb`.`employee_table` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `employee_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `salary` DOUBLE NULL,
  `date_of_joining` DATETIME NULL,
  `bonus` DECIMAL NULL,
  PRIMARY KEY (`employee_id`));

  INSERT INTO employee_table (employee_name,email,salary,date_of_joining,bonus) 
  VALUES('Martin','martin.cs2009@yahoo.com',6000.00,'2017-05-17',400.00);