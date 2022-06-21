/*

drop table customer_purchase;
drop table art;
drop table artist;
drop table customer;

*/

BEGIN TRANSACTION;

CREATE TABLE customer
(
	customer_id SERIAL,
	name VARCHAR(100) NOT NULL,
	address VARCHAR(150) NOT NULL,
	phone VARCHAR(11) NULL,
	
	CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);


CREATE TABLE artist
(
	artist_id SERIAL,
	first_name VARCHAR(50),
	last_name VARCHAR(100),
	
	CONSTRAINT pk_artist PRIMARY KEY (artist_id)

);

CREATE TABLE art
(
	art_code VARCHAR(3),
	title VARCHAR(150),
	artist_id INT NOT NULL,
	
	CONSTRAINT pk_art PRIMARY KEY (art_code),
	CONSTRAINT fk_art_artist FOREIGN KEY (artist_id) REFERENCES artist (artist_id),
	CONSTRAINT uq_title UNIQUE (title)
);



CREATE TABLE customer_purchase
(
	customer_id INT NOT NULL,
	art_code VARCHAR(3) NOT NULL,
	purchase_date TIMESTAMP NOT NULL,
	price MONEY not null,
	
	CONSTRAINT pk_customer_purchase PRIMARY KEY (customer_id, art_code, purchase_date),
	CONSTRAINT fk_customer_puchase_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
	CONSTRAINT fk_customer_purchase_art FOREIGN KEY (art_code) REFERENCES art (art_code),
	CONSTRAINT chk_price CHECK(CAST(price AS MONEY) >= CAST(500.00 AS MONEY)) -- added the cast as postgreSQ, requires cast when using money
	
);




COMMIT TRANSACTION;  --transaction keyword here is optional

