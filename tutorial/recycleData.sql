CREATE DATABASE IF NOT EXISTS zebb_yam;
USE zebb_yam;
-----------------------------------------------------------------------
CREATE TABLE recycleData (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(30),
    weight DOUBLE,
    days INT,
    month VARCHAR(30),
    image_name VARCHAR(255),
    image_data LONGBLOB,
);