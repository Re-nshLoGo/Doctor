# Doctor Patient Application
### Requirments
 * IntelliJIDEA
 * Serverport: 8080 (use: localhost:8080)
 * Java version: 17
 * MySql Databse
 * Everything is present in the pom.xml (no need to download any library)
 ### Steps to run program
 * Download the source code and import in intellijIDEA.
 * Go to localhost:8080/ 
 * Type endpoints in url or
 * You Can also Use Swagger 
 
### There are two models of -
1- Doctor has -
  * doctorId
  * docName
  * docExp
  * specializedIn

2- Patient (Many patients can be treated by one doctor means - ManyToOne relationship) -
  * patientId
  * name
  * age
  * phone
  * deasestype
  * gender
  * docId
  * admitDate;

### Note
* You can change server port by setting properties in application.properties file i.e.

        server.port=8081
 
 

