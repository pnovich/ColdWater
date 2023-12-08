# Water and Gas monitoring App

### How to run
mvn spring-boot:run

### Description
Application creates records about using water and gas and saves it for specific user.

### How to use
There is a public API with two methods:
get : localhost:8080/records/{id}
for getting all records for user,
and 
post : localhost:8080/records/{id}
for creating a new record, where id is path variable and recordDto is json.

### Notes
http://localhost:8080

* [Swagger API](http://localhost:8080/coldwater-openapi)
* App validates user input: 
* json data values should be more than zero, less than 999999, and not empty
* clients(user) id in path variable should already exist
* after starting app creates three clients(users) with ids: 1,2,3, and two records for user 1.
* all other records should be added using API.