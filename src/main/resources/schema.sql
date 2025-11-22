-- Explicit schema for customers table to ensure data.sql runs successfully
CREATE TABLE IF NOT EXISTS customers (
  customer_id BIGINT PRIMARY KEY,
  full_name VARCHAR(255),
  email VARCHAR(255) NOT NULL,
  balance DECIMAL(19,2),
  currency VARCHAR(10),
  CONSTRAINT uq_customers_email UNIQUE (email)
);

-- Product Table
CREATE TABLE IF NOT EXISTS product (
  product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  merchant_id BIGINT,
  product_code VARCHAR(10),
  product_name VARCHAR(100),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
