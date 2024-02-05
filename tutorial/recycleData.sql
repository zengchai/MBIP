CREATE DATABASE IF NOT EXISTS zebb_yam;
USE zebb_yam;
-----------------------------------------------------------------------
CREATE TABLE recycleData (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(30),
    weight DOUBLE,
    month VARCHAR(30),
    image_name VARCHAR(255),
    image_data LONGBLOB,
    recycling_carbon_factor DOUBLE
);

CREATE TABLE electricaldata (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(30) NOT NULL,
    location VARCHAR(50),
    water_consumption DOUBLE,
    electricity_consumption DOUBLE,
    recycling_amount DOUBLE,
    carbon_reduction_rate DOUBLE
    
);

CREATE TABLE timeline(
    
    month VARCHAR(50),
    title VARCHAR(20),
    description VARCHAR(50)
);
