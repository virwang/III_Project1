package project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
//import java.lang.module.ResolutionException;

public class ExcelSQL {
	public static void main(String[] args) {
//		Url url = new URL("PATH");
		try {
			String connUrl = "jdbc:sqlserver://localhost:1433;databaseName=JDBCDB";
			java.sql.Connection conn = DriverManager.getConnection(connUrl, "wang", "1001");
			FileInputStream fis = new FileInputStream("D:\\Project1\\project.csv");
			InputStreamReader isr = new InputStreamReader(fis, "MS950");
			BufferedReader brdFile = new BufferedReader(isr);
			Statement stmt = conn.createStatement();
			String strLine = null;
			stmt.executeQuery("delete from TestPublic ");

			int lineNumber = 0;
			while ((strLine = brdFile.readLine()) != null) {
//            	System.out.println(strLine);
				lineNumber++;
				if (lineNumber == 1) {
					continue;
				}
				String[] array = strLine.split(",");
				System.out.println(strLine);
				for (int i = 0; i < array.length; i++) {
					System.out.println(array[i]);
				}
				// String capital = array[4].replace(",", ""); //56,656,333

				String qryInsert = "insert into TestPublic values(?,?,?,?,?)";

				PreparedStatement pstmt = conn.prepareStatement(qryInsert);

				pstmt.setInt(1, Integer.valueOf(array[0]));
				pstmt.setString(2, array[1]);
				pstmt.setDate(3, java.sql.Date.valueOf(array[2]));
				pstmt.setDate(4, java.sql.Date.valueOf(array[3]));
				pstmt.setString(5, array[4]);

				pstmt.execute();
				isr.close();
				stmt.close();
			}
			;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
