
INSERT INTO customers(id, name, datebirth, address, city, district, zipcode, celphone, email)
VALUES(1, 'Francisco da Silva', '1982-02-06', 'Rua 123, 1235', 'São Paulo', 'Centro', '19660-000', '11955872174', 'francisco@bol.com.br');

INSERT INTO customers(id, name, datebirth, address, city, district, zipcode, celphone, email)
VALUES(2, 'Getúlio Ellis Fino', '1974-12-01', 'Av. dos Pipoqueiros', 'Bahia', 'Jardim Cisne', '69025-000', '77954772174', 'getulio@terra.com.br');

INSERT INTO customers(id, name, datebirth, address, city, district, zipcode, celphone, email)
VALUES(3, 'Alice Efeminada', '1994-11-08', 'Viela do Luminoso, casa 57', 'Amazonas', 'Parque das Formigas', '66660-574', '88195362174', 'alice@gmail.com');

INSERT INTO products(id, description, quantity, price)
VALUES(1, 'Produto A', 140, 97.22);

INSERT INTO products(id, description, quantity, price)
VALUES(2, 'Produto B', 90, 32.44);

INSERT INTO products(id, description, quantity, price)
VALUES(3, 'Produto C', 10, 711.99);

INSERT INTO products(id, description, quantity, price)
VALUES(4, 'Produto D', 62, 320.99);

INSERT INTO products(id, description, quantity, price)
VALUES(5, 'Produto E', 2400, 17.5);

INSERT INTO orders(id, datebuy, idcustomer)
VALUES(1,'2020-10-21',1);

INSERT INTO orders(id, datebuy, idcustomer)
VALUES(2,'2020-10-20',2);

INSERT INTO orders(id, datebuy, idcustomer)
VALUES(3,'2020-10-22',3);

INSERT INTO itensorders(id, idorder, idproduct, quantity, price)
VALUES(1,1,1,2,97.22);

INSERT INTO itensorders(id, idorder, idproduct, quantity, price)
VALUES(2,1,4,3,320.99);

INSERT INTO itensorders(id, idorder, idproduct, quantity, price)
VALUES(3,2,2,8,32.44);

INSERT INTO itensorders(id, idorder, idproduct, quantity, price)
VALUES(4,3,3,4,711.99);

INSERT INTO itensorders(id, idorder, idproduct, quantity, price)
VALUES(5,3,5,10,17.5);

INSERT INTO itensorders(id, idorder, idproduct, quantity, price)
VALUES(6,3,2,20,32.44);

