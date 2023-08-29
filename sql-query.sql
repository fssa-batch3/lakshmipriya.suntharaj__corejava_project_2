USE project;
select* from user;
DROP TABLE user;

CREATE TABLE User (
    UserID int,
    UserName varchar(255),
    EmailId varchar(255)
   
    
);
select* from User_table;
drop table User_table;
select * from User;
drop table User_table;
drop table User;
CREATE TABLE USER (
    Userid int ,
    Username varchar(255),
    email varchar(255),
    password varchar(255)
    
  
);
ALTER TABLE USER
ADD password varchar(255);
select* from USER;

DROP TABLE USER;

select* from USER;

-- INSERT INTO USER (Username ,email,password) VALUES (?,?,?);

select* from recipes;

drop table recipes;
CREATE TABLE recipes (
    recipeId  int,
    name varchar(1000),
    description varchar(1000),
    ingredients varchar (1000),
    instructions varchar (1000),
    imageUrl varchar (1000),
    Category varchar(255)
    
);
select* from recipes;

select* from recipes where Category = "veg";
select* from recipes where Category = "nonveg";


