package project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPublic {

	public static void main(String[] args) {
		
		try {
				java.sql.Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName:JDBC", "wang", "1001");
				
				FileReader fr = new FileReader("D:\\Project1\\Public.xls");
				BufferedReader brFile = new BufferedReader(fr);
				String strLine = null;
				
				while((strLine = brFile.readLine())!=null) {
					
					String[] array= strLine.split(",");
					System.out.println(strLine);
					for (int i = 0; i < array.length; i++) {
						System.out.println(array[i]);				
					}
		String qryInsert = "insert into custinfo values(?,?)";			
		PreparedStatement pstmt = conn.prepareStatement(qryInsert); 			
		
		pstmt.setString(1,array[0]);
		pstmt.setInt(2,Integer.valueOf(array[1]));
//		pstmt.setString(3,array[2]));
				
		pstmt.execute();		
				
			};
			 catch (SQLException e) {
	e.printStackTrace();
}

System.out.println("finish");

}

	}

}
