package project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVSQL {
	public static void main(String[] args) {
//		Url url = new URL("PATH");
		try {			
			FileInputStream fis = new FileInputStream("D:\\Project1\\project.csv");
			InputStreamReader isr = new InputStreamReader(fis,"MS950");
			BufferedReader brdFile = new BufferedReader(isr);
            BufferedReader br = new BufferedReader(isr);
            Connection connection =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JDBCDB", "wang", "1001");
            PreparedStatement pstmt= connection.prepareStatement("insert into TestPublic values(?,?,?,?,?)");
			
			pstmt.executeBatch();
			
			
			};
		}catch(

	FileNotFoundException e)
	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(
	IOException e)
	{
				// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(
	SQLException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}}
