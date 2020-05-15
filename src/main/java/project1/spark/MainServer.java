package project1.spark;

import java.io.File;
import java.util.LinkedHashMap;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import project1.spark.Servlets.MainServlet;
import project1.spark.io.SparkLoadFile;
import project1.spark.io.SqlDataSource;
import project1.spark.io.SqlSparkRepository;
import project1.spark.io.PlayersCSV;
	
public class MainServer {
	public static void main(String[] args) throws LifecycleException {
		String csvfile = "C:\\Users\\Daniel\\Documents\\project1\\players_20db.csv";
		
		SparkConf sc = new SparkConf()
					   .setAppName("Project 1")
					   .setMaster("local");
		
		JavaSparkContext jsc = new JavaSparkContext(sc);
		
        JavaRDD<PlayersCSV> FifaDb = new SparkLoadFile(csvfile).createRDD(jsc);
        
		RDDTransform sparkRdds = new RDDTransform(FifaDb);
        LinkedHashMap<String, String> playerData = sparkRdds.getFifaData();
        
		SqlDataSource dataSource = SqlDataSource.getInstance();
		SqlSparkRepository sqlSpark = new SqlSparkRepository(dataSource);
		
		for (String name : playerData.keySet()) {
			sqlSpark.insertAll(name, playerData.get(name));
        }
        
		Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir(new File("target/tomcat/").getAbsolutePath());
        tomcat.setPort(8080);
        tomcat.getConnector();
        tomcat.addWebapp("/spark", new File("src/main/webapp/").getAbsolutePath());
        Wrapper mainServlet = tomcat.addServlet("/spark", "MainServlet", new MainServlet());
        mainServlet.addMapping("/transformations");
        tomcat.start();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("Shutting down tomcat");
                    tomcat.stop();
                } catch (LifecycleException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
