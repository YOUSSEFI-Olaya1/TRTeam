package connect;

import java.sql.Connection;
import java.sql.DriverManager;


public class Connectiondb {
	@SuppressWarnings("restriction")
	public static Connection connect(){
		Connection conn=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/TRteam","root","Omaima");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conn;

	}

}
