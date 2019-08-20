
/*
Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
*/
SELECT 
    p.Id As Product_ID,
    p.Name AS Product_Title,
    p.Price AS Product_Price,
    p.Quntity,
    c.Type As Category_Type
FROM
    PRODUCT p,
    CATEGORY c,
    ProductCategory pc
WHERE
    p.Id = pc.Prod_Id AND c.Id = pc.Cat_Id
ORDER BY p.Date DESC;


/*
Display the list of products which don't have any images.
*/
select p1.name
from PRODUCT p1
where not exists (select *
from IMAGE i 
where p1.id = i.Prod_Id);


/*
Display all Id, Title and Parent Category Title for all the Categories listed, sorted by Parent Category Title and then Category Title. (If Category is top category then Parent Category Title column should display “Top Category” as value.)
*/
SELECT 
    c1.id,
    c1.Type,
    IFNULL((SELECT Type FROM CATEGORY WHERE Id = c1.parentid) ,"TOp") AS PARENT_NAME
FROM
    CATEGORY c1
        LEFT JOIN
    CATEGORY c2 ON c2.parentid = c2.Id ORDER BY  PARENT_NAME ,c1.Type;
    
/*
Display Id, Title, Parent Category Title of all the leaf Categories (categories which are not parent of any other category)
*/
SELECT 
    c1.id AS ID, c1.type AS LEAFNODE , IFNULL((SELECT Type FROM CATEGORY WHERE id = c1.parentId),"Top") As ParentName
FROM
    CATEGORY c1
WHERE
    NOT exists( 
    SELECT *
    FROM
        CATEGORY
    WHERE
        c1.id = parentId);
        

/*
Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
*/
SELECT *
FROM
    PRODUCT
WHERE
    quntity <= 50;
        
    
 /*
 Display the list of Products whose Quantity on hand (Inventory) is under 50.
 */
SELECT 
    p1.name As Name,
    p1.Id As Id,
    p1.color As Color,
    p1.Price as Price,
    p1.Quntity as Quantity 
FROM
    PRODUCT p1
Where
    p1.id in ((SELECT 
    
        Prod_id As Pro
    FROM
        ProductCategory
    WHERE
        Cat_Id = (SELECT id
        FROM
            CATEGORY
        WHERE
            Type = 'Shirt')));
            
            
/*
Assignment 3:
Write SQL scripts for the following:
Display Recent 50 Orders placed (Id, Order Date, Order Total).
*/
SELECT 
    o.Order_Id,
    o.Orderdate,
    (SELECT 
        sum(TotalAmount)
    FROM
        Item_Order
    where
        Order_Id = o.Order_Id
    group by Order_Id) As Total_Price
from
    Orders o
Order by o.OrderDate desc
limit 2;


/*
Display 10 most expensive Orders.
*/
SELECT 
    o.Order_id, o.Product_id, sum(TotalAmount) as Total
FROM
    item_order o
        LEFT JOIN
    orders o1 ON o.Order_Id = o1.Order_Id
Group by o.Order_Id
Order By Total DESC
limit 3;

/*
Display all the Orders which are placed more than 10 days old and one or more items from those orders are still not shipped.
*/
SELECT 
    U.ID, U.name, U.Email, U.Number
from
    orders,
    User U
WHERE
    DATEDIFF(now(), orders.orderDate) > 10 AND orders.Status = 'P' AND U.Id = orders.user_id;    
    
/*
Display list of shoppers which haven't ordered anything since last month.
*/
SELECT *
from
    user
where
    ID not IN ((SELECT 
        user_id
    from
        orders
    WHERE
        DATEDIFF(now(), orderDate) < 30));
 
 /*
 Display list of shopper along with orders placed by them in last 15 days. 
 */
 SELECT 
    u.*, count(Order_id) as Total_Order
from
    orders,
    user u
WHERE
    DATEDIFF(now(), orders.orderDate) > 15 AND u.Id = user_id
group by user_id;
 
/*
Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
*/
Select *
from
    product
WHERE
    id IN (SELECT 
        product_id
    from
        Item_Order
    where
        order_id = 10);
 
 
/*
Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
*/
SELECT 
    o1.Order_Id, o1.Product_Id, o.OrderDate, o1.TotalAmount
FROM
    ORDERS o,
    item_order o1
WHERE
    o.Order_Id = o1.Order_Id AND o1.TotalAmount BETWEEN 3002 AND 3004; 