CREATE DATABASE shoppingSite;
USE shoppingSite; 
CREATE TABLE user(id INT PRIMARY KEY AUTO_INCREMENT , password varchar(100) not null);
DESCRIBE user;
INSERT INTO user(password) VALUES("rivak");
SELECT * FROM user;

CREATE TABLE PRODUCT(id int PRIMARY KEY AUTO_INCREMENT , type varchar(100) not null , name varchar(100) not null , price double not null);
SELECT * FROM PRODUCT;

CREATE TABLE CART(
   id INT PRIMARY KEY AUTO_INCREMENT,
   user_Id INT NOT NULL,
   product_Id INT NOT NULL,
   quntity INT NOT NULL,
   FOREIGN KEY(user_id) REFERENCES Users(user_id),
   FOREIGN KEY(product_id) REFERENCES Product(product_id));