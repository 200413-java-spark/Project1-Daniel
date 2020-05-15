# ChangeLog

## Version 1.1.2
- Presentable program
### Added
- New Project in Visual Studio Code
- Project 1, io, Servlets, resources, webapp folders
- dummy.csv

### Modified
- pom.xml reconfiguration to jar packaging
- Dockerfile
- schema.sql represents the corect table and changed a varchar value
- sqlDataSource to reflect the correct database name and the correct ip address
- sqlSparkRepository inserting data into the right table and retrieving data from the correct table
- RDDTransform to hold the correct transformations and eliminated some unuseful transformations
- MainServer.java csv file's correct file path
- MainServlet formatting output
- players_20db file was further reduced to get rid of blank spaces and consequently got rid of all GK names and attributes

### Deleted
- players_Demo.csv
- All of Eclipse project code

## Version 1.1.1
### Added
- New package folder io
- New classes loadSpark, sqlDataSource, sqlDataRepository and a csv file class
- New package folder spark
- New java file rddtransform to perform all transformations
- New package folder servlets
- New java file main servlet to contain the servlet that will pull data from database
- Dockerfile
- schema.sql
- players_Demo.csv file to test transformations

### Modified
- pom.xml
- changed server.java to MainServer.java
- reduced the data of players_20db.csv to a more managable dataset
### Deleted
- Bunch of maven dependencies when changing to jar packaging and then back to war packaging

## Version 0.1.1
### Added
- Goodbye servlet
- dummy data to test rdds
- readme, changelog files

### Modified
- pom.xml to package maven into jar
- changed dependencies and added plugins

## Version 0.0.1
### Added
- Hello Servlet
- Server class to embed tomcat
- players_20.csv

### Modified
- pom.xml to containt spark and tomcat dependecies
