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

# For Admin

INSERT INTO users (Email, Password, Username, Level) VALUES ('admin@gmail.com','admin','admin',2);
