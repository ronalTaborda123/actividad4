CREATE TABLE USERS(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    USERNAME VARCHAR NOT NULL,
    PASSWORD VARCHAR NOT NULL
);


CREATE TABLE PRODUCTS(
    ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR NOT NULL,
    DESCRIPTION VARCHAR NOT NULL,
    BASEPRICE DECIMAL NOT NULL,
    TAXRATE DECIMAL NOT NULL,
    PRODUCTSTATUS VARCHAR NOT NULL,
    INVENTORYQUANTITY INT NOT NULL
);