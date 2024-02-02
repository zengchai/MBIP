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
    recycling_carbon_factor DOUBLE
);
CREATE TABLE users (
    id INT auto_increment Primary Key ,
    Username varchar(20),
    Fullname VARCHAR(50),
    Nickname VARCHAR(20),
    Password VARCHAR(30),
    Email VARCHAR(40),
    PhoneNum VARCHAR(30),
    PreferredLanguage VARCHAR(20),
    Category VARCHAR(20),
    Poscode VARCHAR(20),
    Address VARCHAR(100),
    Level INT
);
CREATE TABLE winners (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(30) NOT NULL,
    location VARCHAR(50),
    water_consumption DOUBLE,
    electricity_consumption DOUBLE,
    recycling_amount DOUBLE,
    carbon_reduction_rate DOUBLE
    
);

CREATE TABLE electricaldata (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(255),
    electricityusage DECIMAL(5, 2) NOT NULL,
    days INT NOT NULL,
    month VARCHAR(255),
    proportion_factor DECIMAL(5, 2) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    current_charge DECIMAL(10, 2) NOT NULL,
    image_name VARCHAR(255),
    image_data LONGBLOB,
    electrical_carbon_factor DOUBLE
);

CREATE TABLE waterdata (
    id INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(255),
    waterusage DECIMAL(5, 2) NOT NULL,
    days INT NOT NULL,
    month VARCHAR(255),
    proportion_factor DECIMAL(5, 2) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    image_name VARCHAR(255),
    image_data LONGBLOB,
    water_carbon_factor DOUBLE
);
