#### DiscoverOrg Smart Fridge Interface
Clone the project, in the root directory you will find a Java program and an Angular6 app.

### Java Program
Import the Java program to run it in your IDE, and use the port 8080 to check the methods.

### Angular6 App
Make sure Node is installed, in terminal run these commands:
node -v
(if not download here: https://nodejs.org/en/, npm gets installed with node by default)
go into DiscoverOrgApp directory and run:
ng s
this will serve the app which you can then start to interact with the java back end

## Endpoints:
Post:
https://localhost:8080/addItem
Get:
https://localhost:8080/removeItem?itemType=0001 -- removes item on itemType
https://localhost:8080/getItemsInFridge -- gets all items in fridge
https://localhost:8080/getItems -- creates shopping list for items under 50% fill factor
https://localhost:8080/forgetItem?itemType=1001 -- will not add item to the shopping list
https://localhost:8080/getFillFactor?itemType=1001 -- will not add item to the shopping list

Models:
FridgeItem = {
  itemUUID = "0001", //String
  itemName = "Milk", //String
  itemType = 1002L, //Long
  fillFactor = 1.0 //Double
}