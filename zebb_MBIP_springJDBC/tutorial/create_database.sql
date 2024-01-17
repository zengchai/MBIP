
CREATE DATABASE IF NOT EXISTS mydb;
USE mydb;
-----------------------------------------------------------------------
DROP TABLE products;
CREATE TABLE products (
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    details TEXT,
    price DECIMAL(10, 2),
    stock_quantity INT,
    manufacturer VARCHAR(150)
);


-----------------------------------------------------------------------

INSERT INTO products (product_name, category, details, price, stock_quantity, manufacturer)
VALUES
    ('Laptop', 'Electronics', 'High-performance laptop with 16GB RAM and 512GB SSD.', 999.99, 50, 'ABC Electronics'),
    ('Smartphone', 'Electronics', '5.5-inch display, 128GB storage, dual camera.', 499.99, 100, 'XYZ Mobiles'),
    ('Desk Chair', 'Furniture', 'Ergonomic chair with adjustable height and lumbar support.', 129.99, 30, 'Comfort Furniture'),
    ('Coffee Maker', 'Appliances', 'Programmable coffee maker with 12-cup capacity.', 49.99, 75, 'Home Appliances Co.'),
    ('Running Shoes', 'Clothing', 'High-performance running shoes for all types of terrain.', 79.99, 200, 'Sports Gear Inc.'),
    ('Bookshelf', 'Furniture', 'Wooden bookshelf with adjustable shelves.', 89.99, 40, 'Home Furnishings Ltd.'),
    ('Digital Camera', 'Electronics', '20MP digital camera with 4K video recording.', 299.99, 20, 'Photo Tech'),
    ('Toaster Oven', 'Appliances', 'Compact toaster oven with multiple cooking functions.', 39.99, 60, 'Kitchen Appliances'),
    ('Winter Jacket', 'Clothing', 'Insulated winter jacket with water-resistant fabric.', 149.99, 50, 'Fashion Outfitters'),
    ('Gaming Console', 'Electronics', 'Next-gen gaming console with 1TB storage.', 399.99, 15, 'GameTech Systems');
