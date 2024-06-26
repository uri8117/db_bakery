CREATE DATABASE IF NOT EXISTS BAKERY;
USE BAKERY;

-- (Supplier supplies ingredients)
CREATE TABLE SUPPLIER (
    SUPPLIER_ID INT PRIMARY KEY,
    NAME VARCHAR(255),
    ADDRESS VARCHAR(255),
    PHONE VARCHAR(20)
);

-- (Ingredient is supplied by a supplier)
CREATE TABLE INGREDIENT (
    INGREDIENT_ID INT PRIMARY KEY,
    NAME VARCHAR(255),
    SUPPLIER_ID INT,
    PRICE DECIMAL(10, 2),
    FOREIGN KEY (SUPPLIER_ID) REFERENCES SUPPLIER(SUPPLIER_ID)
);

-- (Product contains ingredients)
CREATE TABLE PRODUCT (
    PRODUCT_ID INT PRIMARY KEY,
    NAME VARCHAR(255),
    PRICE DECIMAL(10, 2)
);

-- (Many-to-Many relationship between PRODUCT and INGREDIENT)
CREATE TABLE PRODUCT_INGREDIENT (
    PRODUCT_ID INT,
    INGREDIENT_ID INT,
    PRIMARY KEY (PRODUCT_ID, INGREDIENT_ID),
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID),
    FOREIGN KEY (INGREDIENT_ID) REFERENCES INGREDIENT(INGREDIENT_ID)
);

-- (Client places orders)
CREATE TABLE CLIENT (
    CLIENT_ID INT PRIMARY KEY,
    NAME VARCHAR(255),
    EMAIL VARCHAR(255),
    ADDRESS VARCHAR(255),
    PHONE VARCHAR(20)
);

-- (Order is placed by a client)
CREATE TABLE `ORDER` (
    ORDER_ID INT PRIMARY KEY,
    ORDER_DATE DATE,
    CLIENT_ID INT,
    FOREIGN KEY (CLIENT_ID) REFERENCES CLIENT(CLIENT_ID)
);

-- (One-to-Many relationship between ORDER and PRODUCT)
CREATE TABLE ORDER_ITEM (
    ORDER_ITEM_ID INT PRIMARY KEY,
    ORDER_ID INT,
    PRODUCT_ID INT,
    QUANTITY INT,
    FOREIGN KEY (ORDER_ID) REFERENCES `ORDER`(ORDER_ID),
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)
);


CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID INT PRIMARY KEY,
    NAME VARCHAR(255),
    POSITION VARCHAR(255)
);

-- (One-to-One relationship with EMPLOYEE)
CREATE TABLE EMPLOYEE_DETAIL (
    EMPLOYEE_ID INT PRIMARY KEY,
    BIRTHDATE DATE,
    SALARY DECIMAL(10, 2),
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID)
);

-- (Many-to-Many relationship between EMPLOYEE and PRODUCT)
CREATE TABLE EMPLOYEE_PRODUCT (
    EMPLOYEE_ID INT,
    PRODUCT_ID INT,
    PRIMARY KEY (EMPLOYEE_ID, PRODUCT_ID),
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID),
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT(PRODUCT_ID)
);

-- (Many-to-Many relationship between EMPLOYEE and ORDER)
CREATE TABLE EMPLOYEE_ORDER (
    EMPLOYEE_ID INT,
    ORDER_ID INT,
    PRIMARY KEY (EMPLOYEE_ID, ORDER_ID),
    FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID),
    FOREIGN KEY (ORDER_ID) REFERENCES `ORDER`(ORDER_ID)
);