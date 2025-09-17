package com.anshumanprajapati.walmart.round2;

interface I {
}
class First implements I{
}
class Second implements I{
}

class Factory{
	volatile I cl1;
	volatile I cl2;
	
	Factory(int c1){
		if(c1==1) {
			if(cl1==null) {
				synchronized (cl1) {
					if(cl1==null) {
						cl1 =new First();
					}
				}
			}
		}
	}
	
	I get(int cl){
		if(cl==1) {
			if(cl1==null) {
				synchronized (cl1) {
					if(cl1==null) {
						cl1 =new First();
					}
				}
			}
			return cl1;
		}
		if(cl==2) {
			return new Second();
		}
		return null;
	}
	
}


public class A{
	public static void main(String[] args) {
		Factory factory = new Factory(0);
		
		I cl1 = factory.get(1);
		I cl2 = factory.get(2);
	}
	
}


/*
 
 
CREATE TABLE Product (ProductID int, ProductName varchar(255), CategoryID int, Price int);

INSERT INTO Product VALUES (1, "Chais", 1, 18); 
INSERT INTO Product VALUES (2, "Chang", 1, 19); 
INSERT INTO Product VALUES (3, "Aniseed Syrup", 2, 10); 

CREATE TABLE Category (CategoryID int, CategoryName varchar(255), Description varchar(1000));

INSERT INTO Category VALUES (1, "Beverages", "Soft drinks, coffees, teas, beers, and ales"); 
INSERT INTO Category VALUES (2, "Condiments", "Sweet and savory sauces, relishes, spreads, and seasonings"); 
INSERT INTO Category VALUES (3, "Confections", " Desserts, candies, and sweet breads"); 


ProductID ProductName CategoryID Price
1 Chais 1 18
2 Chang 1 19
3 Aniseed Syrup 2 10


CategoryID CategoryName Description
1 Beverages Soft drinks, coffees, teas, beers, and ales
2 Condiments Sweet and savory sauces, relishes, spreads, and seasonings
3 Confections Desserts, candies, and sweet breads


// product_Id, pname, name

SELECT p.productId, p.productName, c.categoryName
FROM Product p
LEFT JOIN Category c
ON  p.categoryId = c.categoryId




productId productName cateogyrName
1 Chais Beverages
2 Chang Beverages
3 Anissed Syrup Condiments


*/





















