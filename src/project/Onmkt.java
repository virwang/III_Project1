package project;

import java.sql.*;
import java.io.File;
import java.io.IOException;

public class Onmkt {

	public static void main(String[] args) {
//		Connection connection = null;
	


try(
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName:JDBC", "wang", "1001");
		
		){
	
} catch (SQLException e) {
	e.printStackTrace();
}

System.out.println("finish");

}

}
