SELECT * FROM CATEGORY;
SELECT * FROM PRODUCT;
SELECT * FROM PRODUCTCategory;

/*
Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
*/
SELECT 
    p.*, Count(DISTINCT pc.CAT_ID) AS TOTAL_CATEGORY
FROM
    PRODUCT p
        LEFT JOIN
    PRODUCTCATEGORY pc ON p.id = pc.prod_id
GROUP BY pc.Prod_Id
Having COUNT(CAT_Id) > 1;

/*
Display the Categories along with number of products under each category.
*/
SELECT 
    c.*, Count(DISTINCT pc.Prod_Id) AS TOTAL_PRODUCT
FROM
    CATEGORY c
        LEFT JOIN
    PRODUCTCATEGORY pc ON c.id = pc.Cat_Id
GROUP BY Cat_Id Having count(PROD_ID) >0;

/*
Display Count of products as per below price range:
Range in Rs.
Count
0 - 100
101 - 500
Above 500
*/
SELECT 
    price, count(*) no_of_products
FROM
    (SELECT 
        CASE
                WHEN price >= 0 AND price <= 100 THEN '0-100'
                WHEN price >= 100 AND price <= 500 THEN '100-500'
                WHEN price >= 500 THEN '500>'
            END AS PRICE
    FROM
        PRODUCT) AS count_of_products
GROUP BY price;

/*
Assignment 3:
Write SQL scripts for the following:
Display Shopper’s information along with number of orders he/she placed during last 30 days.
*/
 SELECT 
    u.*, count(Order_id) as Total_Order
from
    orders,
    user u
WHERE
    DATEDIFF(now(), orders.orderDate) < 30 AND u.Id = orders.user_id
    GROUP BY User_Id;
    
    
SELECT * FROM ORDERS;
SELECT * FROM ITEM_ORDER;
SELECT * FROM USER;
SELECT * FROM PRODUCT;
/*
Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
*/
SELECT 
    U.ID, U.Name, O.User_Id, SUM(I.TotalAmount) AS Total_REVENUE
FROM
    ORDERS O,
    User U,
    ITEM_ORDER I
WHERE
    O.Order_ID = I.ORDER_ID AND DATEDIFF(now(), O.orderDate) < 30 AND O.User_Id = U.ID
GROUP BY O.USER_ID DESC
LIMIT 10;

/*
Given a category search keyword, display all the Products present in this category/categories
*/
SELECT 
    product.*
FROM
    product,
    ProductCategory,
    CATEGORY
Where
    product.id = ProductCategory.prod_id AND CATEGORY.type = 't-shirt' AND CATEGORY.id = ProductCategory.cat_id;

/*
Mark the products as Inactive which are not ordered in last 90 days.
*/
SELECT 
    *
FROM
    PRODUCT
WHERE
    ID NOT IN (SELECT DISTINCT
        PRODUCT_ID
    FROM
        ITEM_ORDER I
            LEFT JOIN
        ORDERS O ON O.ORDER_ID = I.ORDER_ID AND DATEDIFF(now(), O.orderDate) < 90);