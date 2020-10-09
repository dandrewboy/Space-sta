DROP TABLE spacesta.users; 
      
CREATE TABLE spacesta.users (
  id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
  username VARCHAR(45) NOT NULL,
  password VARCHAR(45) NOT NULL,
  firstname VARCHAR(45) NOT NULL,
  lastname VARCHAR(45) NOT NULL,
  email VARCHAR(45) NOT NULL,
  phonenumber VARCHAR(45) NOT NULL,
  CONSTRAINT primary_key PRIMARY KEY (id));
  
  
--DROP TABLE spacesta.products; --Uncomment if the products table exists (remove "--").
CREATE TABLE spacesta.products (
  prodId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1, INCREMENT BY 1),
  productName VARCHAR(45) NOT NULL,
  productDescription VARCHAR(45) NOT NULL,
  productQuantity INTEGER NOT NULL,
  productPrice DOUBLE NOT NULL);

--Add Users
  INSERT INTO spacesta.users(username, password, firstname, lastname, email, phonenumber) VALUES('gdavis', '1234', 'Gary', 'Davis','gdavis@test.com', '1234567891');
  INSERT INTO spacesta.users(username, password, firstname, lastname, email, phonenumber) VALUES('tdavis', '1234', 'Tanner', 'Davis','tdavis@test.com', '1234567891');

 --Add Products
  INSERT INTO spacesta.products(productName, productDescription, productQuantity, productPrice) VALUES('Space-sta', 'Shirt', 25, 20.30);
  INSERT INTO spacesta.products(productName, productDescription, productQuantity, productPrice) VALUES('Space-sta', 'Mug', 100, 13.50);
  
  