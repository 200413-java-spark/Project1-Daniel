package project1.spark.io;

import java.io.File;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class SparkLoadFile {
	private String csvFile;
	
	public SparkLoadFile(String csvFile) {
		this.csvFile = csvFile;
	}
	
	public JavaRDD<PlayersCSV> createRDD(JavaSparkContext sparkC){
		JavaRDD<String> playersdb = sparkC.textFile(new File(csvFile).getAbsolutePath()).cache();
		
		String headerRow = playersdb.first();
		JavaRDD<String> playerData = playersdb.filter(line -> !line.equals(headerRow)).cache();
		
		JavaRDD<PlayersCSV> newPlayerData = playerData.map((n) -> {
			String[] column = n.split(",");
			return new PlayersCSV(column[0], column[1], column[2], column[3], column[4], column[5],
					column[6], column[7], column[8], column[9], column[10], column[11], column[12], 
					column[13], column[14], column[15]);
		}).cache();
		
		return newPlayerData;
	}
}
