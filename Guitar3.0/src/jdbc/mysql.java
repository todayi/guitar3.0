package jdbc;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.SQLException;  
  
public class mysql extends lianjie {  
    public static final String url = "jdbc:mysql://localhost/mission?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "123456";  
    public Connection conn = null;  
    
	 public  Connection getConnection(){	
	        try {  
	            Class.forName(name);//指定连接类型  
	            conn = DriverManager.getConnection(url, user, password);//获取连接  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
			
			return conn;
		}
    public void close() {  
        try {  
            this.conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  