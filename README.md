# Skiply
Spring - Student fee management

This project includes implementation of creating students, collecting fee for specific students and viewing their receipts. 

Requirements : 
Maven,
jdk 1.8


Running any service : 
mvn spring-boot:run 


Service Description : 

EurekaServer - Implemented with Netflix eureka. 

student - creates students, collects fees and stores the receipt. Added appropriate validation wherever needed. Implemented using feign client, circuit breaker, spring jpa and in memory H2 database

receipt - store and view receipt functionality implemented. Implemented using feign client, circuit breaker, spring jpa and in memory H2 database

Requests: Sample requests for each service available in postman collection file





