show databases;
create database student;
use student;
create table studentDetails(
    id int PRIMARY KEY AUTO_INCREMENT,
    name varchar(100) not null,
    email varchar(100) not null UNIQUE,
    fatherName varchar(100) not null,
    age int not null,
    class int not null
);

DESCRIBE studentDetails;