DROP DATABASE hadoopguide is EXISTS;
CREATE DATABASE hadoopguide;
use hadoopguide;
CREATE TABLE widgets(id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,widget_name VARCHAR(64) NOT NULL,price DECIMAL(10,2),
design_date DATE,version INT,design_comment VARCHAR(100));
