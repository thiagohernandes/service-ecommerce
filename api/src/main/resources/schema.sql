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