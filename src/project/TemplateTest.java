package project;

import java.sql.*;

public class TemplateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub



try(
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName:JDBC", "wang", "1001");
		
		){
	
} catch (SQLException e) {
	e.printStackTrace();
}

System.out.println("finish");

}



}

	


