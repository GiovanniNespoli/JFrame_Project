CREATE DATABASE projectJAVA;

CREATE TABLE User(

	idLabel 	INT AUTO_INCREMENT PRIMARY KEY,
    name		VARCHAR(100) NOT NULL,
    email		VARCHAR(100) NOT NULL UNIQUE,
    password	VARCHAR(100) NOT NULL

);

INSERT User (name,email,password)
VALUES 	('Giovanni Nespoli', 'gigio@gmail.com', '123'),
		('Iago Martins', 'iago@gmail.com','123');
        
SELECT * FROM User WHERE email = "gigio@gmail.com" AND password = "123";