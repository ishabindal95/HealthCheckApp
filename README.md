# HealthCheckApp

To run, create database and user with permissions. Update the same in /src/main/resources/application.properties.

APIs:

1. (GET)localhost:8080/healthcheckapp/getservicelist -> Lists entries in database
2. (POST)localhost:8080/healthcheckapp/sethealthcheckurl -> Enter values(serviceName, serviceEnvironment, healthURL) in database
3. (GET)localhost:8080/healthcheckapp/gethealthcheckurl?serviceName=<example>&serviceEnvironment=<example> -> Get healthURL for given serviceName and serviceEnvironment
4. (GET)localhost:8080/healthcheckapp/gethealthcheck?serviceName=<example>&serviceEnvironment=<example> -> Get healthURL for given serviceName and serviceEnvironment and call it.
  

Database contains one table:

SERVICE->
String serviceName(Primary key),
String serviceEnvironment(Primary key),
String healthURL
