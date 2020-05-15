# FIFA 20 Database Analysis Application
## Purpose
This application will gather and analyze the data of the FIFA 20 Career Mode player database from EA.
The analyzed data consits of:
- The total number of players in the database
- The average age of all players
- The count of all nationalities
- The count of all overall ratings
- The count of all potential ratings
- The average value in Euros of all players
- The number of 5 star, 4 star, 3 star, 2 star, 1 star weak foot players
- The number of  5 star, 4 star, 3 star, 2 star, 1 star skill moves players
- The count of all positions in the game
- The average pace attribute of all players
- The average shooting attribute of all players
- The average passing attribute of all players
- The average dribbling attribute of all players
- The average defending attribute of all players
- The average physical attribute of all players

## Build
- mvn clean compile package

## Postgres in EC2
- docker build -t players .
- sudo docker run --name players -d --rm -p 5432:5432 players
- sudo docker exec -it players psql -U players

## Usage
- java -jar target/spark-0.0.1-SNAPSHOT.jar
// This command run the main class and the tomcat server

## Design
### Architecture
- MainServer is a batch processing application 
- The io package contains all the io operations and the sql data source to connect to the database. It loads a csv file and parses it using JavaRDDs to only hold the required data to analyze
- The Servlets package holds the http servlet that will retrieve the data from the database and displays it to the user when accessing the localhost on port 8080/spark/transformations

## Main Algorithm
- The main class will take in a csv file, parse it, perform transformations on the data, and send it to the database on EC2
- The csv file will be a parameter in the RDDtransform method that will perform the transformations
- After all the transformations are done, the results will be store in a Linked Map.
- The list will be send to the database using the readAll method
- Tomcat is called having the correct port and the connection to the main servlet





