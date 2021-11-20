SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS `order`;
DROP TABLE IF EXISTS language;
DROP TABLE IF EXISTS promotion;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS translation;
DROP TABLE IF EXISTS order_product;

SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE user
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(72) NOT NULL,
    firstname VARCHAR(50) NOT NULL,
    lastname VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    phone_number varchar(15) NOT NULL,
    city varchar(50) NOT NULL,
    postal_code varchar(50) NOT NULL,
    street varchar(50) NOT NULL,
    house_number varchar(10) NOT NULL
);

CREATE TABLE `order`
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    user INT NOT NULL,

    CONSTRAINT fk_order_user FOREIGN KEY (user) REFERENCES user(id)
);

CREATE TABLE language
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    international_code VARCHAR(10) NOT NULL
);

CREATE TABLE promotion
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    percentage INT NOT NULL
);

CREATE TABLE category
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    label VARCHAR(45) NOT NULL,
    description TEXT,
    promotion INT,

    CONSTRAINT fk_category_promotion FOREIGN KEY (promotion) REFERENCES promotion(id)
);

CREATE TABLE product
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    description TEXT,
    price DOUBLE NOT NULL,
    category INT NOT NULl,

    CONSTRAINT fk_product_category FOREIGN KEY (category) REFERENCES category(id)
);

CREATE TABLE translation
(
    language INT NOT NULL,
    product INT NOT NULL,
    label VARCHAR(45) NOT NULL,

    CONSTRAINT fk_translation_language FOREIGN KEY (language) REFERENCES language(id),
    CONSTRAINT fk_translation_product FOREIGN KEY (product) REFERENCES product(id)
);

CREATE TABLE order_product
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantity INT NOT NULL,
    accorded_price DOUBLE NOT NULL,
    `order` INT NOT NULL,
    product INT NOT NULL,

    CONSTRAINT fk_order_product_order FOREIGN KEY (`order`) REFERENCES `order`(id),
    CONSTRAINT fk_order_product_product FOREIGN KEY (product) REFERENCES product(id)
);

INSERT INTO language (international_code) VALUES ('en');
INSERT INTO language (international_code) VALUES ('fr');

INSERT INTO category (label) VALUES ('Football');
INSERT INTO category (label) VALUES ('Basketball');

INSERT INTO product (price, category) VALUES (10.0, 1);

INSERT INTO translation (language, product, label) VALUES (1, 1, 'Ball');
INSERT INTO translation (language, product, label) VALUES (2, 1, 'Ballon');

set @@global.time_zone = '+00:00' ;
set @@session.time_zone = '+00:00' ;