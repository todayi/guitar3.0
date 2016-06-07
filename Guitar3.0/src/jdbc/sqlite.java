package jdbc;
import java.sql.*;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;


public class sqlite extends lianjie {

	//static String url="jdbc:sqlserver://localhost:1433; DatabaseName=test";
	 String url="jdbc:sqlite://D:/OOAD/O-O-mission/guitar3.0/mission5.db";
	 String jdbc = "org.sqlite.JDBC";
	 Connection conn=null;
	 public  Connection getConnection(){	
	  try{
		 Class.forName(jdbc);	
		 conn=DriverManager.getConnection(url);
		 System.out.println("Success loading Sqlite Driver!");  
		}catch(ClassNotFoundException e){
			
		}		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("e loading Sqlite Driver!");

			e.printStackTrace();
		}
		
		return conn;
	}

}
