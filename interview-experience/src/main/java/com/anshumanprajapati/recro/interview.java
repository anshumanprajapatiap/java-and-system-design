package com.anshumanprajapati.recro;

public class interview {
}

/*
CREATE TABLE Customers (
    customer_id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    created_at DATETIME
);

CREATE TABLE MenuItems (
    item_id INT PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    price DECIMAL(6,2)
);

CREATE TABLE Orders (
    order_id INT PRIMARY KEY,
    customer_id INT REFERENCES Customers(customer_id),
    item_id INT REFERENCES MenuItems(item_id),
    quantity INT,
    order_time DATETIME
);
-----------------------


SELECT MENU.item_id from
MenuItems MENU
LEFT JOIN Orders ORDER
ON ORDER.item_id != MENU.item_id
-----------------------

WITH CUST_CTE AS (
    SELECT customer_id FROM Customers
)
SELECT CUST_CTE.customer_id, COUNT( DISTINCT(ORDER.order_id) ) FROM CUST_CTE
JOIN Orders ORDER
ON CUST_CTE.customer_id = ORDER.customer_id
GROUP BY CUST_CTE.customer_id
-----------------------


WITH MENU_CTE AS (
    SELECT item_id, price FROM MenuItems
)
SELECT SUM(ORDER.quantity *  MENU_CTE.price) FROM Orders ORDER
JOIN MENU_CTE
ON MENU_CTE.item_id = ORDER.item_id
where date(ORDER.order_time) = currentdate()
-------------------------


 */