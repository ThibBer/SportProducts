DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Order;
DROP TABLE IF EXISTS Language;
DROP TABLE IF EXISTS Promotion;
DROP TABLE IF EXISTS Category;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Translation;
DROP TABLE IF EXISTS OrderProduct;

CREATE TABLE User
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

CREATE TABLE Order
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    date DATE NOT NULL,
    user INT NOT NULL,

    CONSTRAINT fk_order_user FOREIGN KEY (user) REFERENCES User(id)
);

CREATE TABLE Language
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    international_code VARCHAR(10) NOT NULL
);

CREATE TABLE Promotion
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    percentage INT NOT NULL
);

CREATE TABLE Category
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    label VARCHAR(45) NOT NULL,
    description TEXT NOT NULL,
    promotion INT,

    CONSTRAINT fk_category_promotion FOREIGN KEY (promotion) REFERENCES Promotion(id)
);

CREATE TABLE Product
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    price DOUBLE NOT NULL,
    category INT NOT NULl,

    CONSTRAINT fk_product_category FOREIGN KEY (category) REFERENCES Category(id)
);

CREATE TABLE Translation
(
    language INT NOT NULL,
    product INT NOT NULL,
    label VARCHAR(45) NOT NULL,
    description TEXT NOT NULL,

    CONSTRAINT fk_translation_language FOREIGN KEY (language) REFERENCES Language(id),
    CONSTRAINT fk_translation_product FOREIGN KEY (product) REFERENCES Product(id)
);

CREATE TABLE OrderProduct
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantity INT NOT NULL,
    accordedPrice DOUBLE NOT NULL,
    order INT NOT NULL,
    product INT NOT NULL,

    CONSTRAINT fk_order_product_order FOREIGN KEY (order) REFERENCES Order(id),
    CONSTRAINT fk_order_product_product FOREIGN KEY (product) REFERENCES Product(id)
);