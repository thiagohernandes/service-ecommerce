CREATE TABLE customers (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    datebirth DATE NOT NULL,
    address VARCHAR(200) NOT NULL,
    city VARCHAR(100) NOT NULL,
    district VARCHAR(100) NOT NULL,
    zipcode VARCHAR(9) NOT NULL,
    celphone VARCHAR(11) NOT NULL,
    email VARCHAR(80) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE products (
    id INTEGER NOT NULL AUTO_INCREMENT,
    description VARCHAR(150) NOT NULL,
    quantity INTEGER NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE orders (
    id INTEGER NOT NULL AUTO_INCREMENT,
    datebuy DATE NOT NULL,
    idcustomer INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idcustomer) REFERENCES customers (id)
);

CREATE TABLE itensorders (
    id INTEGER NOT NULL AUTO_INCREMENT,
    idorder INTEGER NOT NULL,
    idproduct INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (idorder) REFERENCES orders (id),
    FOREIGN KEY (idproduct) REFERENCES products (id)
);
