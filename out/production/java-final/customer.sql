
CREATE TABLE customers (
                           id SERIAL PRIMARY KEY ,
                           last_name TEXT NOT NULL,
                           first_name TEXT NOT NULL,
                           phone_number TEXT NOT NULL
);

INSERT INTO customers (last_name, first_name, phone_number) VALUES ('Doe', 'John', '123456789');
INSERT INTO customers (last_name, first_name, phone_number) VALUES ('Smith', 'Jane', '987654321');
