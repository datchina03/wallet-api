-- Explicit schema for customers table to ensure data.sql runs successfully
CREATE TABLE IF NOT EXISTS customers (
  customer_id BIGINT PRIMARY KEY,
  full_name VARCHAR(255),
  email VARCHAR(255) NOT NULL,
  balance DECIMAL(19,2),
  currency VARCHAR(10),
  CONSTRAINT uq_customers_email UNIQUE (email)
);
