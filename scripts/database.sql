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
    house_number varchar(10) NOT NULL,

    username varchar(50) NOT NULL UNIQUE,
    authorities varchar(50) DEFAULT NULL,
    non_expired boolean DEFAULT NULL,
    non_locked boolean DEFAULT NULL,
    credentials_non_expired boolean DEFAULT NULL,
    enabled boolean DEFAULT NULL
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
    description TEXT NOT NULL,
    promotion INT,
    image VARCHAR(50),

    CONSTRAINT fk_category_promotion FOREIGN KEY (promotion) REFERENCES promotion(id)
);

CREATE TABLE product
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    description TEXT,
    price DOUBLE NOT NULL,
    category INT NOT NULl,
    image VARCHAR(50),

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

    CONSTRAINT fk_order_product_order_ FOREIGN KEY (`order`) REFERENCES `order`(id),
    CONSTRAINT fk_order_product_product_ FOREIGN KEY (product) REFERENCES product(id)
);

INSERT INTO language (international_code) VALUES ('en');
INSERT INTO language (international_code) VALUES ('fr');

INSERT INTO promotion (start_date, end_date, percentage) VALUES (STR_TO_DATE('10-12-2021', '%d-%m-%Y'), STR_TO_DATE('10-02-2022', '%d-%m-%Y'), 10);
INSERT INTO promotion (start_date, end_date, percentage) VALUES (STR_TO_DATE('01-12-2021', '%d-%m-%Y'), STR_TO_DATE('31-12-2021', '%d-%m-%Y'), 25);

INSERT INTO category (label, description, image, promotion) VALUES ('Football', 'Description football', 'soccer.png', 1);
INSERT INTO category (label, description, image) VALUES ('Basketball', 'Description basketball', 'basketball.png');
INSERT INTO category (label, description, image) VALUES ('Hockey', 'Description hockey', 'hockey.png');
INSERT INTO category (label, description, image) VALUES ('Tennis', 'Description tennis', 'tennis.png');
INSERT INTO category (label, description, image) VALUES ('Badminton', 'Description badminton', 'badminton.png');
INSERT INTO category (label, description, image) VALUES ('Ski', 'Description ski', 'ski.png');
INSERT INTO category (label, description, promotion, image) VALUES ('Musculation', 'Description musculation', 2, 'musculation.png');
INSERT INTO category (label, description, image) VALUES ('Volleyball', 'Description volleyball', 'volleyball.png');

/*Football*/
INSERT INTO product (price, category, description, image) VALUES (10.0, 1, 'Adults football ball. Size 9. FIFA licensed for professional matches.', 'football_ball.jpg');
INSERT INTO product (price, category, description, image) VALUES (25.0, 1, 'Adults goalkeeper gloves. Size 10. Light and airy, this pair is perfect for games in dry weather.', 'football_goalkeeper_gloves.jpg');
INSERT INTO product (price, category, description, image) VALUES (50.0, 1, 'Adults size jersey. Robust and durable component at all times, approved by the Belgian red devils.', 'football_jersey.jpg');
INSERT INTO product (price, category, description, image) VALUES (75.0, 1, 'Children size shoes. Good attachment on wet ground. May be prohibited on artificial turf.', 'football_shoes.jpg');
INSERT INTO product (price, category, description, image) VALUES (15.0, 1, 'Children shin pads. Resists to violent shocks.', 'football_shin_pads.jpg');

/*Basketball*/
INSERT INTO product (price, category, description, image) VALUES (14.0, 2, 'Adult standard size basketball ball. Official ball used for competitions', 'basketball_ball.png');
INSERT INTO product (price, category, description, image) VALUES (475.0, 2, 'This ProSport Basketball Hoop adjusts from 1.5 to 3.05 meters to allow players of all ages and skill levels to get out and shoot some hoops.', 'basketball_hoop.jpg');
INSERT INTO product (price, category, description, image) VALUES (20.5, 2, 'This basketball shirt present a comfortable cut to move freely on the field.', 'basketball_shirt.jpg');
INSERT INTO product (price, category, description, image) VALUES (7, 2, 'This basketball short present a comfortable cut to move freely on the field.', 'basketball_short.jpg');
INSERT INTO product (price, category, description, image) VALUES (35, 2, 'This medidu ankle brace will help you avoid breaking your ankles while failing a dunk.', 'basketball_ankle_brace.jpg');
INSERT INTO product (price, category, description, image) VALUES (20, 2, 'This 25L bag is the best to keep your stuff safely. Moreover, you can place your basket ball in it', 'basketball_bag.jpg');

/*Hockey*/
INSERT INTO product (price, category, description, image) VALUES (40, 3, 'Professional stick, 20% in carbone material. Ideal to deal with the hardest moves in the sport.', 'hockey_stick.jpg');
INSERT INTO product (price, category, description, image) VALUES (42, 3, 'Adults shin pads. Resists to violent shocks.', 'hockey_shin_pads.jpg');
INSERT INTO product (price, category, description, image) VALUES (16, 3, 'Adult standard size hockey ball. Official ball used for competitions', 'hockey_ball.jpg');
INSERT INTO product (price, category, description, image) VALUES (30, 3, 'Training cones.', 'hockey_cones.jpg');


INSERT INTO translation (language, product, label) VALUES (1, 1, 'Ball');
INSERT INTO translation (language, product, label) VALUES (2, 1, 'Ballon');

INSERT INTO translation (language, product, label) VALUES (1, 2, 'Goalkeeper gloves');
INSERT INTO translation (language, product, label) VALUES (2, 2, 'Gants de gardien');

INSERT INTO translation (language, product, label) VALUES (1, 3, 'Jersey');
INSERT INTO translation (language, product, label) VALUES (2, 3, 'Maillot');

INSERT INTO translation (language, product, label) VALUES (1, 4, 'Shoes');
INSERT INTO translation (language, product, label) VALUES (2, 4, 'Chaussures');

INSERT INTO translation (language, product, label) VALUES (1, 5, 'Shin pads');
INSERT INTO translation (language, product, label) VALUES (2, 5, 'Protèges tibias');

INSERT INTO translation (language, product, label) VALUES (1, 6, 'Ball');
INSERT INTO translation (language, product, label) VALUES (2, 6, 'Ballon');

INSERT INTO translation (language, product, label) VALUES (1, 7, 'Basketball hoop');
INSERT INTO translation (language, product, label) VALUES (2, 7, 'Panier de basket');

INSERT INTO translation (language, product, label) VALUES (1, 8, 'Basketball shirt');
INSERT INTO translation (language, product, label) VALUES (2, 8, 'Maillot de basket');

INSERT INTO translation (language, product, label) VALUES (1, 9, 'Basketball short');
INSERT INTO translation (language, product, label) VALUES (2, 9, 'Short de basket');

INSERT INTO translation (language, product, label) VALUES (1, 10, 'Ankle brace');
INSERT INTO translation (language, product, label) VALUES (2, 10, 'Chevillère');

INSERT INTO translation (language, product, label) VALUES (1, 11, 'Bag');
INSERT INTO translation (language, product, label) VALUES (2, 11, 'Sac');

INSERT INTO translation (language, product, label) VALUES (1, 12, 'Stick');
INSERT INTO translation (language, product, label) VALUES (2, 12, 'Bâton');

INSERT INTO translation (language, product, label) VALUES (1, 13, 'Shin pads');
INSERT INTO translation (language, product, label) VALUES (2, 13, 'Protèges tibias');

INSERT INTO translation (language, product, label) VALUES (1, 14, 'Hockey ball');
INSERT INTO translation (language, product, label) VALUES (2, 14, 'Balle de hockey');

INSERT INTO translation (language, product, label) VALUES (1, 15, 'Training cones');
INSERT INTO translation (language, product, label) VALUES (2, 15, 'Cônes d\'entraînement');

INSERT INTO user (email, password, firstname, lastname, birth_date, phone_number, city, postal_code, street, house_number, username, authorities, non_expired, non_locked, credentials_non_expired, enabled)
VALUES ('thibaut.berg@hotmail.com', '$2a$10$Q40BovIcYkzsz6NtxW8VAe7TqdY9vEzDeWRm/5ht27PIxOAuPcgwG', 'Thibaut', 'Berg', STR_TO_DATE('28/10/2001', '%d/%m/%Y'), '0478782002', 'Marche-en-Famenne', 6900, 'Rue des champs', 53, 'Spike', 'ROLE_USER', 1, 1, 1, 1);
INSERT INTO user (email, password, firstname, lastname, birth_date, phone_number, city, postal_code, street, house_number, username, authorities, non_expired, non_locked, credentials_non_expired, enabled)
VALUES ('nicobern.play@gmail.com', '$2a$10$Q40BovIcYkzsz6NtxW8VAe7TqdY9vEzDeWRm/5ht27PIxOAuPcgwG', 'Nicolas', 'Bernard', STR_TO_DATE('07/12/2000', '%d/%m/%Y'), '0470565656', 'Spontin', 5530, 'Rue du château', 36, 'Bernico', 'ROLE_USER', 1, 1, 1, 1);

set @@global.time_zone = '+00:00' ;
set @@session.time_zone = '+00:00' ;