/*
Assignment 4:
Consider a form where providing a Zip Code populates associated City and
State. 
Create appropriate tables and relationships for the same and write a SQL
         query for that returns a Resultset containing Zip Code, City Names and
         States ordered by State Name and City Name.
*/

CREATE TABLE ZIPCODE(
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ZipCode INT NOT NULL
);

INSERT INTO ZIPCODE(ZipCode) VALUES(314080),(302017),(302018),(303030),(311212),(12345),(223344),(223344),(223344);

SELECT 
    *
FROM
    ZIPCODE;

CREATE TABLE city_state(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    zipcode_id INT,
    FOREIGN KEY (zipcode_id)
        REFERENCES zipcode (ID),
    city char(11),
    state char(11)
);  

INSERT INTO city_state(zipcode_id,city,state) 
VALUES(1,'RAWATBHATA','RAJASTHAN'),
(2,'MUMBAI','MAHARASHTRA'),
(3,'JAIPUR','RAJASTHAN'),
(4,'DELHI','DELHI'),
(5,'Panji','GOA'),
(6,'Ahembdabad','Gujrat'),
(7,'patna','Bihar'),
(8,'Kishangarh','Rajasthan'),
(9,'Hyderabad','Telangana');

SELECT 
    Z.ZipCode, cs.City, cs.State
FROM
    ZIPCODE Z
        LEFT JOIN
    city_State cs ON cs.zipcode_Id = Z.Id
ORDER BY cs.state,cs.city;

