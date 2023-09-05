USE project;
select* from user;
DROP TABLE user;


CREATE TABLE USER (
    Userid int ,
   email varchar(255),
    Username  varchar(255),
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
ALTER TABLE recipes
ADD isDeleted varchar(255);

select* from recipes where Category = "veg";
select* from recipes where Category = "nonveg";


