/*
Database Management System - Assignments
Session 2

Assignment 1:
Write SQL scripts for the following:
Create all tables of eCommerce Application: StoreFront covered in Session 1 Assignments. (Write all CREATE commands in a SQL file and run that SQL File).
Write a command to display all the table names present in StoreFront.
Write a command to remove Product table of the StoreFront database.
Create the Product table again.

*/



show Databases;
CREATE DATABASE Amazon;
USE Amazon;
CREATE TABLE PRODUCT
(
Name char(30),
Id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
Color CHAR(20),
Price FLOAT,
Quntity INT,
date DATETIME
);
DESCRIBE PRODUCT;
CREATE TABLE IMAGE 
(
Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Prod_Id int,
name VARCHAR(200),
FOREIGN KEY(Prod_Id) REFERENCES PRODUCT(Id)
);
CREATE TABLE USER 
(
ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
Name CHAR(30), 
Email VARCHAR(200),
Password VARCHAR(200),
Number INT(10)
);
CREATE TABLE Address 
(
Id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
City CHAR(10),
PinCode INT(6),
State CHAR(10),
UserId INT,
FOREIGN KEY(UserId) REFERENCES USER(ID)
);

CREATE TABLE CATEGORY
(
Id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Type CHAR(100),
ParentId INT,
Description VARCHAR(200)
);

CREATE TABLE ProductCategory
(
Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
Cat_Id INT,
Prod_Id INT,
FOREIGN KEY(Prod_Id) REFERENCES PRODUCT(Id),
FOREIGN KEY(Cat_Id) REFERENCES CATEGORY(Id)
);

CREATE TABLE Administrator
(
Id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
User_Id INT,
FOREIGN KEY(User_Id) REFERENCES USER(ID)
);
CREATE TABLE Orders
(
Order_Id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
Quntity INT,
User_Id INT,
FOREIGN KEY(User_Id) REFERENCES USER(ID)
);

DESCRIBE  Orders

CREATE TABLE Item_Order
(
Order_Id INT,
Product_Id INT,
FOREIGN KEY(Order_Id) REFERENCES Orders(Order_Id),
FOREIGN KEY(Product_Id) REFERENCES PRODUCT(Id)
);

SHOW Tables;





/*
Assignment 2:
Write SQL scripts for the following:
Insert sample data in StoreFront tables by using SQL files.
*/

INSERT INTO PRODUCT
(
Name,
Id,
Color,
Price,
Quntity
)
VALUES
("Reebok" , 1 , "RED" , "2000" , "200"),
("Puma" , 2 , "GREEN" , "3000" , "240"),
("RoadStar",3 , "BLACK" , "4000" , "210"),
("Arrow" , 4 , "WHITE" , "5000" , "100"),
("SonyTv" , 5 , "black" , "500" , "10"),
("SamsungTv" , 6 , "Blue" , "500" , "10"),
("Jbl" , 7 , "venom" , "500" , "10"),
("Boss" , 8 , "iron" , "500" , "10"),
("DoorMats" ,9 ,  "gold" , "500" , "10"),
("WallClock" , 10 , "silver" , "500" , "10"),
("Pantings" , 11 , "platinum" , "500" , "10"),
("SofaCover" ,12  , "copper" , "500" , "10");

SELECT * FROM PRODUCT;

INSERT INTO category (Id,Type,Description,ParentId) 
VALUES(1,'Cloth',"Clothing for men and women",NULL);

INSERT INTO category (id,type,Description,ParentId) 
VALUES(2,'Electronic',"Electronic aplliances for your home and office",NULL);

INSERT INTO category (id,type,Description,ParentId) 
VALUES(3,'Home',"Design your home with us",NULL);

INSERT INTO category (id,type,Description,ParentId) 
VALUES(4,'T-shirt',"T-Shirt for men and women",1);

INSERT INTO category (id,type,Description,ParentId) 
VALUES(5,'Shirt',"Shirt from popular brands",1);

INSERT INTO category (id,type,Description,ParentId) 
VALUES(6,'TV',"All type of television",2);

INSERT INTO category (id,type,Description,ParentId) 
VALUES(7,'Headphones',"Headphones for you",2);

INSERT INTO category (id,type,Description,ParentId) 
VALUES(8,'Home furnishing',"Furnish your home",3);

INSERT INTO category (id,type,Description,ParentId)
VALUES(9,'Home Decor',"Decor your home",3);


INSERT INTO category (id,type,Description,ParentId)
VALUES(10,'Muflas',"Muflas your home",9);


SELECT * FROM ProductCategory;


INSERT INTO ProductCategory
(
Cat_Id,
Prod_Id
)
VALUES
(4,1),
(4,2),
(5,3),
(5,4),
(6,5),
(6,6),
(7,7),
(7,8),
(8,9),
(8,12),
(9,10),
(9,11),
(1,13),
(2,14);

INSERT INTO IMAGE
(
Prod_Id,
name
)
VALUES
(1,"Rivak.png"),
(1,"vinay.png"),
(2,"vinod.png"),
(3,"surendra.png"),
(2,"Rakesh.png"),
(4,"Raju.png"),
(3,"Ram.png"),
(4,"pankaj.png"),
(3,"jugal.png"),
(5,"upendra.png"),
(6,"bhupendra.png"),
(7,"ss.png"),
(8,"pankaj.png"),
(9,"jugal.png"),
(10,"upendra.png"),
(11,"bhupendra.png"),
(11,"ss.png");

SELECT * FROM IMAGE;


SELECT * FROM ProductCategory;

INSERT INTO user (Name, Email, Password,Number) 
VALUES ('VINAY',"vinay.pancholi@gmail.com","123456",941493997);

INSERT INTO user (Name, Email, password,Number) 
VALUES ('RIVAK',"rivak.shah@gmail.com","123456",774892758);

INSERT INTO user (Name, Email, Password,Number) 
VALUES ('AJAY',"ajay11@gmail.com","123456",941499997);

INSERT INTO user (Name, Email, Password,Number) 
VALUES ('VIKAS',"vikas090@gmail.com","123496",941493397);


INSERT INTO Administrator
(
User_Id
)
VALUES
(1),
(3),
(4);

SELECT * FROM Address;

INSERT INTO Address
(
City,
PinCode,
State,
UserId
)
VALUES
("jaipur" , 23212, "Raj" ,1),
("Udaipur" , 23211, "Raj" ,1),
("Ajmer" , 23221, "Raj" ,2),
("Dungarpur" , 232112 ,"Raj" ,2),
("pali" , 232112 ,"UP" ,4),
("Ahmedabad" , 233321 , "GUJ" ,3);



INSERT INTO Orders 
(
OrderDate,
user_id 
) 
VALUES
("2019-11-05 0:00:00",01),("2019-11-04 0:00:00",2),("2019-11-03 0:00:00",3),("2019-11-02 0:00:00",4),("2019-11-01 0:00:00",4);
SELECT * FROM Orders ;

INSERT INTO Item_Order
(
order_id,
product_id 
)
VALUES
(6,2),
(7,3),
(8,1),
(9,3),
(10,2),
(10,1);

SELECT * FROM Orders;
