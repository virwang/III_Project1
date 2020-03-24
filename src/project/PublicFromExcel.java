package project;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PublicFromExcel {

	public static void main(String[] args) {
//			Connection connection = null;
		try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JDBCDB",
				"wang", "1001");
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select*from TestPublic");) {

			FileReader fr = new FileReader("D:\\Project1\\Public.xls");
			BufferedReader brdFile = new BufferedReader(fr);
			String strLine = null;

			while ((strLine = brdFile.readLine()) != null) {
				String[] array = strLine.split(",");
				System.out.println(strLine);
				for (int i = 0; i < array.length; i++) {
					System.out.println(array[i]);
				}
				String qryInsert = "insert into TestPublic values(?,?,?,?,?)";
				PreparedStatement pstmt = connection.prepareStatement(qryInsert);

				pstmt.setInt(1, Integer.valueOf(array[0]));
				pstmt.setString(2, array[1]);
				pstmt.setDate(3, java.sql.Date.valueOf(array[2]));
				pstmt.setDate(4, java.sql.Date.valueOf(array[3]));
				BigDecimal ar5 = new BigDecimal(array[4]);
				pstmt.setBigDecimal(5, ar5);
				
				pstmt.executeUpdate();
				pstmt.clearParameters();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e3) {
			e3.printStackTrace();
		} catch (SQLException e4) {
			e4.printStackTrace();
		}

		System.out.println("finish");

	}
}