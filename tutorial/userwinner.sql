CREATE DATABASE IF NOT EXISTS zebb_yam;
USE zebb_yam;
-----------------------------------------------------------------------
CREATE TABLE winner (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(30) NOT NULL,
    location VARCHAR(50),
    water_consumption DOUBLE,
    electricity_consumption DOUBLE,
    recycling_amount DOUBLE,
    carbon_reduction_rate DOUBLE
    
);