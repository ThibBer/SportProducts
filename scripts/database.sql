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
    enabled boolean DEFAULT NULL,

    CONSTRAINT user_birth_date_check CHECK ( birth_date < SYSDATE() ),
    CONSTRAINT user_postal_code_check CHECK ( postal_code between 1000 AND 9999 )
);

CREATE TABLE `order`
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    user INT NOT NULL,

    CONSTRAINT order_date_check CHECK ( date >= DATE(SYSDATE()) ),
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
    percentage INT NOT NULL,

    CONSTRAINT promotion_end_date_check CHECK ( end_date >= DATE(SYSDATE()) ),
    CONSTRAINT promotion_dates_check CHECK ( start_date <= end_date ),
    CONSTRAINT promotion_percentage_check CHECK ( percentage > 0 )
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

    CONSTRAINT product_price_check CHECK ( price > 0 ),
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

    CONSTRAINT order_product_quantity_check CHECK ( quantity > 0 ),
    CONSTRAINT order_product_accorded_price_check CHECK ( accorded_price > 0 ),
    CONSTRAINT fk_order_product_order_ FOREIGN KEY (`order`) REFERENCES `order`(id),
    CONSTRAINT fk_order_product_product_ FOREIGN KEY (product) REFERENCES product(id)
);

INSERT INTO language (international_code) VALUES ('en');
INSERT INTO language (international_code) VALUES ('fr');

INSERT INTO promotion (start_date, end_date, percentage) VALUES (STR_TO_DATE('15-12-2021', '%d-%m-%Y'), STR_TO_DATE('10-02-2022', '%d-%m-%Y'), 10);
INSERT INTO promotion (start_date, end_date, percentage) VALUES (STR_TO_DATE('01-12-2021', '%d-%m-%Y'), STR_TO_DATE('05-02-2022', '%d-%m-%Y'), 25);

INSERT INTO category (label, description, image, promotion) VALUES ('Football', 'Football is the most practiced sport worldwide, in addition to being close to a religion in several countries. It is the heart sport of millions of people.', 'soccer.png', 1);
INSERT INTO category (label, description, image) VALUES ('Basketball', 'Basketball is one of the most popular sports in the world. The best known championship is the NBA in North America with its franchised teams.', 'basketball.png');
INSERT INTO category (label, description, image) VALUES ('Hockey', 'Hockey is not the most famous sport, but it is played in many countries, such as Belgium or India. Belgium is currently Olympic champion.', 'hockey.png');
INSERT INTO category (label, description, image) VALUES ('Tennis', 'Tennis is a sport where the greatest players compete in tournaments. Roland-Garros is the most famous one.', 'tennis.png');
INSERT INTO category (label, description, image) VALUES ('Badminton', 'Badminton is often played non-competitively, and does not seem overwhelming. Yet, played competitively, it is one of the most tiring sports.', 'badminton.png');
INSERT INTO category (label, description, image) VALUES ('Ski', 'The favorite sport of one of our employees, skiing brings, in addition to sensations, a magnificent view of the rooftops of the world.', 'ski.png');
INSERT INTO category (label, description, promotion, image) VALUES ('bodybuilding', 'Strength training helps strengthen different muscles. This helps prevent injuries when playing other sports.', 2, 'musculation.png');
INSERT INTO category (label, description, image) VALUES ('Volleyball', 'Volleyball is one of the most popular sports in the world. Its practice must combine team cohesion as well as a certain endurance.', 'volleyball.png');

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
INSERT INTO product (price, category, description, image) VALUES (16, 3, 'Adult standard size hockey ball. Official ball used for competitions.', 'hockey_ball.jpg');
INSERT INTO product (price, category, description, image) VALUES (30, 3, 'Training cones.', 'hockey_cones.jpg');

/*Tennis*/
INSERT INTO product (price, category, description, image) VALUES (120, 4, 'Professional racket, 255gr of pur technology in your hands to execute the best smashes.', 'tennis_racket.jpg');
INSERT INTO product (price, category, description, image) VALUES (5.90, 4, 'These tennis balls are ideals for the player looking for a competitive but durable items. Official Wilson US Open balls.', 'tennis_balls.jpg');
INSERT INTO product (price, category, description, image) VALUES (134.99, 4, 'Do you want to show off your power ? This radar is made for your.', 'tennis_radar.jpg');
INSERT INTO product (price, category, description, image) VALUES (15, 4, 'Children rackets to discover the world of tennis.', 'tennis_children_racket.jpg');
INSERT INTO product (price, category, description, image) VALUES (9, 4, 'Children tennis shoes. Perfect for any type of field.', 'tennis_children_shoes.jpg');
INSERT INTO product (price, category, description, image) VALUES (15, 4, 'You don\'t have a field in you backyards ? This tennis trainer is for you.', 'tennis_trainer.jpg');
INSERT INTO product (price, category, description, image) VALUES (12, 4, 'Tennis poles to create a field anywhere you want.', 'tennis_pole.jpg');
INSERT INTO product (price, category, description, image) VALUES (2, 4, 'Perfect bag to put some balls into it.', 'tennis_bag.jpg');

/*Badminton*/
INSERT INTO product (price, category, description, image) VALUES (22, 5, 'Professional racket, Power, tolerance and resistance are these assets.', 'badminton_racket.jpg');
INSERT INTO product (price, category, description, image) VALUES (5, 5, 'Thanks to its plastic skirt, this shuttlecock allows stable trajectories, even when you are new to badminton.', 'badminton_shuttlecocks.jpg');
INSERT INTO product (price, category, description, image) VALUES (60, 5, 'Badminton net to play in a club. Easy to assemble.', 'badminton_net.jpg');

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

INSERT INTO translation (language, product, label) VALUES (1, 16, 'Tennis racket');
INSERT INTO translation (language, product, label) VALUES (2, 16, 'Raquette de tennis');
INSERT INTO translation (language, product, label) VALUES (1, 17, 'Tennis balls');
INSERT INTO translation (language, product, label) VALUES (2, 17, 'Balles de tennis');
INSERT INTO translation (language, product, label) VALUES (1, 18, 'Radar');
INSERT INTO translation (language, product, label) VALUES (2, 18, 'Radar');
INSERT INTO translation (language, product, label) VALUES (1, 19, 'Children rackets');
INSERT INTO translation (language, product, label) VALUES (2, 19, 'Raquette enfant');
INSERT INTO translation (language, product, label) VALUES (1, 20, 'Children shoes');
INSERT INTO translation (language, product, label) VALUES (2, 20, 'Chaussure enfant');
INSERT INTO translation (language, product, label) VALUES (1, 21, 'Tennis trainer');
INSERT INTO translation (language, product, label) VALUES (2, 21, 'Entraineur de tennis');
INSERT INTO translation (language, product, label) VALUES (1, 22, 'Field Poles');
INSERT INTO translation (language, product, label) VALUES (2, 22, 'Poteaux de terrain');
INSERT INTO translation (language, product, label) VALUES (1, 23, 'Tennis bag');
INSERT INTO translation (language, product, label) VALUES (2, 23, 'Sac de tennis');

INSERT INTO translation (language, product, label) VALUES (1, 24, 'Badminton racket');
INSERT INTO translation (language, product, label) VALUES (2, 24, 'Raquette de badminton');
INSERT INTO translation (language, product, label) VALUES (1, 25, 'Badminton shuttlecock');
INSERT INTO translation (language, product, label) VALUES (2, 25, 'Volant de badminton');
INSERT INTO translation (language, product, label) VALUES (1, 26, 'Badminton net');
INSERT INTO translation (language, product, label) VALUES (2, 26, 'Fillet de badminton');

INSERT INTO user (email, password, firstname, lastname, birth_date, phone_number, city, postal_code, street, house_number, username, authorities, non_expired, non_locked, credentials_non_expired, enabled)
VALUES ('thibaut.berg@hotmail.com', '$2a$10$Q40BovIcYkzsz6NtxW8VAe7TqdY9vEzDeWRm/5ht27PIxOAuPcgwG', 'Thibaut', 'Berg', STR_TO_DATE('28/10/2001', '%d/%m/%Y'), '0478782002', 'Marche-en-Famenne', 6900, 'Rue des champs', 53, 'Spike', 'ROLE_USER', 1, 1, 1, 1);
INSERT INTO user (email, password, firstname, lastname, birth_date, phone_number, city, postal_code, street, house_number, username, authorities, non_expired, non_locked, credentials_non_expired, enabled)
VALUES ('nicobern.play@gmail.com', '$2a$10$Q40BovIcYkzsz6NtxW8VAe7TqdY9vEzDeWRm/5ht27PIxOAuPcgwG', 'Nicolas', 'Bernard', STR_TO_DATE('07/12/2000', '%d/%m/%Y'), '0470565656', 'Spontin', 5530, 'Rue du château', 36, 'Bernico', 'ROLE_USER', 1, 1, 1, 1);

set @@global.time_zone = '+00:00' ;
set @@session.time_zone = '+00:00' ;