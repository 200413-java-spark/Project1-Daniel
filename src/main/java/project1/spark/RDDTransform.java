package project1.spark;

import java.util.LinkedHashMap;

import org.apache.spark.api.java.JavaRDD;

import project1.spark.io.PlayersCSV;
import scala.Tuple2;

public class RDDTransform {
	JavaRDD<PlayersCSV> fifaData;
	private LinkedHashMap<String, String> playerdata = new LinkedHashMap<String, String>();
	
	public RDDTransform(JavaRDD<PlayersCSV> fifaData) {
		this.fifaData = fifaData;
		
		// Total Data in file
		this.playerdata.put("DataCount", Double.toString(dataCount()));
		//this.playerdata.put("PlayerCount", playerCount());
		// Averages of all ages
		this.playerdata.put("AgeAverage", Double.toString(ageAvg()));
		// Count of all Nationalities
		this.playerdata.put("NationalityCount", nationalityCount());
		//this.playerdata.put("ClubCount", clubCount());
		// Counts all the overall ratings of all players
		this.playerdata.put("OverallCount", overallCount());
		// Counts all the potential ratings of all players
		this.playerdata.put("PotentialCount", potentialCount());
		// Averages the value of all players
		this.playerdata.put("ValueEuroAverage", Double.toString(valueEuroAvg()));
		// Counts the weakfoot of all players
		this.playerdata.put("WeakFootCount", weakFootCount());
		// Counts the skill moves of all players
		this.playerdata.put("SkillMoveCount", skillMoveCount());
		// Counts the all the positions of all players
		this.playerdata.put("PositionCount", positionCount());
		// Averages the pace stat of all players
		this.playerdata.put("PaceAverage", Double.toString(paceAvg()));
		// Averages the shoothing stat of all players
		this.playerdata.put("ShootingAverage", Double.toString(shootingAvg()));
		// Averages the passing stat of all players
		this.playerdata.put("PassingAverage", Double.toString(passingAvg()));
		// Averages the dribbling stat of all players
		this.playerdata.put("DribblingAverage", Double.toString(dribblingAvg()));
		// Averages the defending stat of all players
		this.playerdata.put("DefendingAverage", Double.toString(defendingAvg()));
		// Averages the physical stat of all players
		this.playerdata.put("PhysicalAverage", Double.toString(physicalAvg()));
	}
	
	public String getFifaData(String name) {
		return playerdata.get(name);
	}
	
	public LinkedHashMap<String, String> getFifaData(){
		return playerdata;
	}
	
	/*private String playerCount() {
		return fifaData.mapToPair((f) -> new Tuple2<>(f.name, 1)).reduceByKey((x, y) -> ((int) x + (int) y)).collect().toString();
	}*/
	
	/*private String ageCount() {
		return fifaData.mapToPair((f) -> new Tuple2<>(f.age, 1)).reduceByKey((x, y) -> ((int) x + (int) y)).collect().toString();
	}*/
	
	// All counts
	private String nationalityCount() {
		return fifaData.mapToPair((f) -> new Tuple2<>(f.nationality, 1)).reduceByKey((x, y) -> ((int) x + (int) y)).collect().toString();
	}
	
	/*private String clubCount() {
		return fifaData.mapToPair((f) -> new Tuple2<>(f.club, 1)).reduceByKey((x, y) -> ((int) x + (int) y)).collect().toString();
	}*/
	
	private String overallCount() {
		return fifaData.mapToPair((f) -> new Tuple2<>(f.overall, 1)).reduceByKey((x, y) -> ((int) x + (int) y)).collect().toString();
	}
	
	private String potentialCount() {
		return fifaData.mapToPair((f) -> new Tuple2<>(f.potential, 1)).reduceByKey((x, y) -> ((int) x + (int) y)).collect().toString();
	}
	
	private String weakFootCount() {
		return fifaData.mapToPair((f) -> new Tuple2<>(f.weakFoot, 1)).reduceByKey((x, y) -> ((int) x + (int) y)).collect().toString();
	}
	
	private String skillMoveCount() {
		return fifaData.mapToPair((f) -> new Tuple2<>(f.skillMove, 1)).reduceByKey((x, y) -> ((int) x + (int) y)).collect().toString();
	}
	
	private String positionCount() {
		return fifaData.mapToPair((f) -> new Tuple2<>(f.position, 1)).reduceByKey((x, y) -> ((int) x + (int) y)).collect().toString();
	}
	
	// All averages
	private double dataCount() {
		return fifaData.count();
	}
	private double ageAvg() {
		return fifaData.map((f) -> (double)f.age).reduce((x, y) -> (x + y))/fifaData.count();
	}
	private double valueEuroAvg() {
		return fifaData.map((f) -> (double)f.valueEuro).reduce((x, y) -> (x + y))/fifaData.count();
	}
	private double paceAvg() {
		return fifaData.map((f) -> (double)f.pace).reduce((x, y) -> (x + y))/fifaData.count();
	}
	
	private double shootingAvg() {
		return fifaData.map((f) -> (double)f.shooting).reduce((x, y) -> (x + y))/fifaData.count();
	}
	
	private double passingAvg() {
		return fifaData.map((f) -> (double)f.passing).reduce((x, y) -> (x + y))/fifaData.count();
	}
	
	private double dribblingAvg() {
		return fifaData.map((f) -> (double)f.dribbling).reduce((x, y) -> (x + y))/fifaData.count();
	}
	
	private double defendingAvg() {
		return fifaData.map((f) -> (double)f.defending).reduce((x, y) -> (x + y))/fifaData.count();
	}
	
	private double physicalAvg() {
		return fifaData.map((f) -> (double)f.physical).reduce((x, y) -> (x + y))/fifaData.count();
	}
}
