
import java.sql.*;
import java.util.*;

public class step_2{

     public static void main(String[] args) throws  SQLException,ClassNotFoundException {

          String usrName = "root";
          String pswd = "itmd521";
          Class.forName("com.mysql.jdbc.Driver");
          String hostName = "jdbc:mysql://localhost/hadoopguide";
          Connection con = null;
          Statement stmt = null;
          ResultSet rset = null;
          ResultSetMetaData rsetmd = null;
          Statement dltStmt = null;
          ArrayList<ArrayList<Object>> dabData = null;
          Statement atSt = null;
          Statement insrtStr = null;
          int clCount =0;
          ArrayList<String> clName = null;
          try{
              
              con = DriverManager.getConnection(hostName, usrName, pswd);
              stmt = con.createStatement();
              System.out.println("A connection has been initialised.");
              
              rset =  stmt.executeQuery("select * from hadoopguide.widgets;");
              System.out.println("Data has been retrieved");
              
              rsetmd = rset.getMetaData();
              clCount = rsetmd.getColumnCount();
              dabData = new ArrayList<ArrayList<Object>>();
              clName = new ArrayList<String>();
              
                for (int i = 1; i <= clCount; i++) 
                {
                	String colm = "";
                    colm = rsetmd.getColumnName(i);
                    clName.add(colm);

                }
                
                while (rset.next()) 
                {
                    ArrayList<Object> row = new ArrayList<Object>(clCount);

                    for (int i = 1; i <= clCount; i++) 
                    {
                        row.add(rset.getObject(i));
                    }
                    dabData.add(row);
                }
                
                rset.close();
                stmt.close();
                System.out.println("delete data now");
                dltStmt = con.createStatement();
                dltStmt.executeUpdate("delete from hadoopguide.widgets;");
                System.out.println("Data has been deleted now");
                
                atSt = con.createStatement();
                atSt.executeUpdate("ALTER TABLE hadoopguide.widgets AUTO_INCREMENT = 1;");
                System.out.println("Auto-increment has been added.");
                
              for(int i=0; i<5000; i++)
              {
                  Random rdm = new Random();
                  int a1 = rdm.nextInt(3);
                  int a2 = rdm.nextInt(3);
                  int a3 = rdm.nextInt(3);
                  int a4 = rdm.nextInt(3);
                  int a5 = rdm.nextInt(3);
                  
                  String newStrng = "";
                  if(dabData.get(a5).get(5) != null)
                      newStrng = "Insert into hadoopguide.widgets values(NULL,'"+ dabData.get(a1).get(1).toString() 
                      + "',"+ dabData.get(a2).get(2).toString() + ",'"+ dabData.get(a3).get(3).toString()  
                      + "',"+ dabData.get(a4).get(4).toString() + ",'"+ dabData.get(a5).get(5).toString() + "')";
                  else
                      newStrng = "Insert into hadoopguide.widgets values(NULL,'"+ dabData.get(a1).get(1).toString() 
                      + "'," + dabData.get(a2).get(2).toString() + ",'"+ dabData.get(a3).get(3).toString()  
                      + "',"+ dabData.get(a4).get(4).toString() + ", NULL)"; 
                  insrtStr = con.createStatement();
                  insrtStr.executeUpdate(newStrng);
                  insrtStr.close();
              }
              System.out.println("Execution has been completed.");
          }
          catch(SQLException exception){
              System.out.println("An exception while performing database operations.");
              exception.printStackTrace();
          }
          finally
          {
        	  con.close();
        	  System.out.println("Connection has been closed now.");
          }
     }     
}