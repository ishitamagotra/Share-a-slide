package max_temp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.zip.GZIPInputStream;

public class MaxTemp {
	
	ResultSet imResultSet = null;
    boolean imSuccess = true;
    int[] imExecuteResult = null;
	int imAirTemperature;
	int imYear;	
	private static final int MISSING = 9999;
	private static final String COMMA = ",";
	private static final String SEPARATOR = "\n";
	static Statement imStatement = null;
	static Connection imConnection= null;
	
	ResultSet imFirstDatasetResultSet = null;
	ResultSet imSecondDatasetResultSet = null;
	
	String imFirstSqlQuery = "";
	String imSecondSqlQuery = "";
	
	String imLine1 = " ";
	FileWriter imFileWriter1 = null;
	String imQuality1 = null;
	String[] imDataSet1 = {"1990.gz","1991.gz"};
	
	String imLine2 = " ";
	FileWriter imFileWriter2 = null;
	String imQuality2 = null;
	String[] imDataSet2 = {"1992.gz","1993.gz"};
	
	String imSqlDataset1 = "";
	String imSqlDataset2= "";
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			imConnection = DriverManager.getConnection("jdbc:mysql://localhost/Phase3", "root","itmd521");
			imStatement = imConnection.createStatement();						
		}
		catch(Exception e)
		{
			System.out.println("An exception occured while getting the connection."+e);
		}

		return imConnection;
	}
	
	public static void main(String[] argv) throws Exception {
		try
		{
			MaxTemp imMaxTemp = new MaxTemp();
			long beginTime = System.currentTimeMillis();
			
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("Select your dataset (1/2):");
			 int inputScanner = scanner.nextInt();
			 switch (inputScanner) {
			case 1: 
				imMaxTemp.firstDataset();
				break;
			case 2:
				imMaxTemp.secondDataset();
				
				break;
	
			default:
				break;
			}
			long endingTime = System.currentTimeMillis();
			System.out.println((endingTime - beginTime / 1000) + " " + "seconds");
		}
		catch (Exception e)
		{
			System.out.println("An exception occured while starting the program."+e);
		}
	  }
	
	public void firstDataset() throws Exception{
		try
		{
			createFirstTable();
			readFirstData();
			insertFirstDataset();
			imFirstDatasetResultSet = getFirstResultSet();
			  while (imFirstDatasetResultSet.next()) 
			  {
				   System.out.println(imFirstDatasetResultSet.getInt(1) + " " + imFirstDatasetResultSet.getInt(2));
			  }
		}
		catch (Exception e)
		{
			System.out.println("An exception occured while reading the first dataset."+e);
		}
	}
	
	public void secondDataset() throws Exception{
		try
		{
			createSecondTable();
			readSecondData();
			insertSecondDataset();
			imSecondDatasetResultSet = getSecondResultSet();
			  while (imSecondDatasetResultSet.next()) 
			  {
				System.out.println(imSecondDatasetResultSet.getInt(1) + " " + imSecondDatasetResultSet.getInt(2));
			  }
		}
		catch (Exception e)
		{
			System.out.println("An exception occured while reading the second dataset."+e);
		}
	}
	
	public void createFirstTable() throws Exception{
		try
			{
				imConnection = getConnection();
				
				imStatement = imConnection.createStatement();
				imFirstSqlQuery = "CREATE TABLE dataset_1" +
							 "(sno INTEGER not NULL AUTO_INCREMENT," + "year INT," + "Air_Temp INT," + "PRIMARY KEY(sno))";
				imStatement.executeUpdate(imFirstSqlQuery);
				imStatement.close();
			}
		catch (Exception e)
		{
			System.out.println("An exception occured while creating the first table."+e);
		}		
	}
	
	public void createSecondTable() throws Exception{
			try
			{
				imConnection = getConnection();
				
				imStatement = imConnection.createStatement();
				imSecondSqlQuery = "CREATE TABLE dataset_2" +
							 "(sno INTEGER not NULL AUTO_INCREMENT," + "year INT," + "Air_Temp INT," + "PRIMARY KEY(sno))";
				imStatement.executeUpdate(imSecondSqlQuery);
				imStatement.close();
			}
			catch (Exception e) 
			{
				System.out.println("An exception occured while creating the second table."+e);
			}		
	}
	
	void readFirstData() throws Exception 
	{
		imFileWriter1 = new FileWriter("dataset_1.csv");
		for(String tempSet : imDataSet1){
			InputStream fileStream = new FileInputStream(tempSet);
			InputStream gzipStream = new GZIPInputStream(fileStream);	 
			Reader imReader = new InputStreamReader(gzipStream, "US-ASCII");
		
			try (BufferedReader imBufferedReader = new BufferedReader(imReader)) {
				while((imLine1 = imBufferedReader.readLine())!= null) {
					imYear = Integer.parseInt(imLine1.substring(15, 19));
					if (imLine1.charAt(87) == '+') { 
						imAirTemperature = Integer.parseInt(imLine1.substring(88, 92));
					} else {
	    			imAirTemperature = Integer.parseInt(imLine1.substring(87, 92));
	    		}
					imQuality1 = imLine1.substring(92, 93);
	    		if (imAirTemperature != (MISSING) && imQuality1.matches("[01459]")) {
	    			imFileWriter1.append(String.valueOf(imYear));
	    			imFileWriter1.append(COMMA);	    		
	    			imFileWriter1.append(String.valueOf(imAirTemperature));
	    			imFileWriter1.append(SEPARATOR);
	    		}
	    	}
	    }
		
	catch (Exception e) 
	{
		System.out.println("An exception occured while reading the second dataset."+e);
	}
		}
	}

	void readSecondData() throws Exception {
		
		imFileWriter2 = new FileWriter("dataset_2.csv");
		for(String tempSet : imDataSet2){
			InputStream fileStream = new FileInputStream(tempSet);
			InputStream gzipStream = new GZIPInputStream(fileStream);	 
			Reader decoder = new InputStreamReader(gzipStream, "US-ASCII");
		
			try (BufferedReader bf = new BufferedReader(decoder)) {
				while((imLine2 = bf.readLine())!= null) {
					imYear = Integer.parseInt(imLine2.substring(15, 19));
					if (imLine2.charAt(87) == '+') { 
						imAirTemperature = Integer.parseInt(imLine2.substring(88, 92));
					} else {
	    			imAirTemperature = Integer.parseInt(imLine2.substring(87, 92));
	    		}
				imQuality2 = imLine2.substring(92, 93);
	    		if (imAirTemperature != (MISSING) && imQuality2.matches("[01459]")) {
	    		    imFileWriter2.append(String.valueOf(imYear));
	    		    imFileWriter2.append(COMMA);	    		
	    		    imFileWriter2.append(String.valueOf(imAirTemperature));
	    		    imFileWriter2.append(SEPARATOR);
	    		}
	    	}
	    }
		
	catch (Exception e) {
		System.out.println("An exception occured while reading the second dataset."+e);
	}
		}
	}
	
	public void insertFirstDataset() throws Exception{
		try
		{
		imStatement = imConnection.createStatement();
		imSqlDataset1 = "LOAD DATA LOCAL INFILE '" + "./dataset_1.csv" + "' INTO TABLE dataset_1 FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (year,Air_Temp) ";	
		imStatement.execute(imSqlDataset1);
		}
		catch (Exception e)
		{
			System.out.println("An exception occured inserting the first dataset."+e);
		}
	}
	
	public void insertSecondDataset() throws Exception{
		try
		{
			imStatement = imConnection.createStatement();
			imSqlDataset2 = "LOAD DATA LOCAL INFILE '" + "./dataset_2.csv" + "' INTO TABLE dataset_2 FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (year,Air_Temp) ";	
			imStatement.execute(imSqlDataset2);
		}
		catch (Exception e)
		{
			System.out.println("An exception occured inserting the second dataset."+e);
		}
	}
	
	public static ResultSet getFirstResultSet() throws Exception 
	{
		ResultSet resultSet1 = null;
		try {
			imStatement = imConnection.createStatement();
			String firstResultSetSql = "select year,max(Air_Temp) from dataset_1";
			resultSet1 = imStatement.executeQuery(firstResultSetSql);
		} catch (Exception e) {
			System.out.println("An exception occured while returing the first result set."+e);
		}
		return resultSet1;
	}
	
	public static ResultSet getSecondResultSet() throws Exception {
		ResultSet resultSet2 = null;
		try {
			
			imStatement = imConnection.createStatement();
			String secondResultSetSql = "select year,max(Air_Temp) from dataset_2 group by year";
			resultSet2 = imStatement.executeQuery(secondResultSetSql);
		} catch (Exception e) {
			System.out.println("An exception occured while returing the second result set."+e);
		}
		return resultSet2;
	}
}
