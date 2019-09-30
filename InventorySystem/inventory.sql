CREATE DATABASE Inventory_System;
USE Inventory_System;

CREATE TABLE Inventory ( id INT AUTO_INCREMENT PRIMARY KEY,
           name VARCHAR(20) NOT NULL UNIQUE,
           quantity INT NOT NULL);
            
INSERT INTO Inventory(name , quantity) VALUES("Apple" , 100) , ("Mango" , "200") , ("grapes" , 300)