# Employee Management System
# Simple CRUD-Spring Boot - project
##  Introduction
This is a simple spring boot project I have implemented with all the crud operations in a simple way.

##  Technologies Used
*  Spring Boot
*  MySQL
*  Hibernate

##  IDE used
*  IntelliJ IDEA

##  API Signatures
Here I have run this application in localhost and 8883 port. You can change the port as you wish.

### localhost:8883/employee/save
This endpoint will save an employee in employee database. (a record will insert to employee table).

### localhost:8883/employee/getall
This endpoint will give details of all the employees as a List.

### localhost:8883/employee/getone/{employeeId}
This endpoint will give details of the employee, that we send the employee id in the url.

### localhost:8883/employee/delete/{employeeId}
This endpoint will delete the employee, given the employee id in the url.(delete the record of that employee from employee table)

### localhost:8883/employee/update
This endpoint will update the details of an employee. (update the employee table)

###  Import project to IDE
First you need to clone the project from the GitHub repository and then open the project using IntelliJ as below.
*  File -> Open -> select your project
###  Create the Database
Create a database as _**employee**_ in your MySQL workbench. You can create your own database. it doesn’t have to be the name as _**employee**_ in my case I used the database as _**employee**_. You can create your oen database.  If you are creating your own database, then you must change the database name in property file to the name of your changed database. You can find it in below image, the database name is highlighted.

And, database _**username**_ and _**password**_ must change according to your MySQL configuration.
```diff
- NOTE:- 
You only need to create the database; you must not create the tables. 
when you run the application Hibernate will create the tables in the employee database for you.
```
Then Build and Run your project.    
You can test all the routes of the API using postman. Here I have include all the screen shots of API calls using postman.

```diff
! POST 
  localhost:8883/employee/save
```
```diff
+ GET  
  localhost:8883/employee/getall
```
```diff
+ GET  
  localhost:8883/employee/getone/2
```
```diff
- DELETE  
  localhost:8883/employee/delete/2
```
```diff
# PUT  
  localhost:8883/employee/update
```
