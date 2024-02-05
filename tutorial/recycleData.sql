CREATE DATABASE IF NOT EXISTS zebb_yam;
USE zebb_yam;

Drop table timeline;
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
    Level INT,
    Winner VARCHAR(40),
    CarbonReduction INT
);

CREATE TABLE timeline(
  id INT AUTO_INCREMENT PRIMARY KEY,
    month VARCHAR(50),
    title VARCHAR(100),
    description TEXT
);
insert into timeline (month,title,description) Values
 ("2024-02-02","Go Green 1.0","Welcome everyone to 'Go Green 1.0'! We're thrilled to have you join us in this celebration of sustainability. Together, let's explore eco-friendly practices, share ideas, and make a positive impact on our planet. Thanks for being here; let's make today unforgettable"),
 ("2024-02-02","Go Gotong Royong 1.0",'Welcome to Gotong-Royong Taman Bunga! Today, we unite under the banner of Let''s Clean Together. It''s a collective effort to beautify and uplift our community garden. Thank you for joining hands as we work together towards a cleaner, greener space. Let''s make a positive impact and enjoy the satisfaction of creating a more vibrant environment. Let the cleaning commence!');