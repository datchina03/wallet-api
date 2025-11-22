-- Sample data for customers table (H2)
-- Columns: customer_id, full_name, email, balance, currency

MERGE INTO customers (customer_id, full_name, email, balance, currency) KEY (customer_id) VALUES
  (1001, 'John Doe', 'john.doe@example.com', 500.00, 'USD');

MERGE INTO customers (customer_id, full_name, email, balance, currency) KEY (customer_id) VALUES
  (1002, 'Jane Smith', 'jane.smith@example.com', 250.50, 'USD');

MERGE INTO customers (customer_id, full_name, email, balance, currency) KEY (customer_id) VALUES
  (1003, 'Alice Brown', 'alice.brown@example.com', 1000.00, 'EUR');

MERGE INTO customers (customer_id, full_name, email, balance, currency) KEY (customer_id) VALUES
  (1004, 'datchina', 'datchina@example.com', 10000.00, 'INR');

MERGE INTO customers (customer_id, full_name, email, balance, currency) KEY (customer_id) VALUES
  (1003, 'prasanna', 'prasanna@example.com', 10000.00, 'INR');

-- Add more rows as needed
