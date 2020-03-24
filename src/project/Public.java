package project;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
//import com.sun.corba.se.pept.transport.Connection;

public class Public {

	public static void main(String[] args) {
//			Connection connection = null;
		try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JDBCDB",
				"wang", "1001");
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery("select*from TestPublic");) {

			PreparedStatement pstmt = connection
					.prepareStatement("insert into TestPublic ( CompanyID, CompanyName,SetUpDate, PublicDate, RealCapital)values(?,?,?,?,?)");

			pstmt.setInt(1,1101);
			pstmt.setString(2,"台灣水泥股份有限公司");			
			GregorianCalendar calendar = new GregorianCalendar(1950,12,29);
			java.sql.Date date = new java.sql.Date(calendar.getTimeInMillis());
			pstmt.setDate(3, date);			
			GregorianCalendar calendar2 = new GregorianCalendar(1962,02,9);
			java.sql.Date date2 = new java.sql.Date(calendar2.getTimeInMillis());
			pstmt.setDate(4, date2);		
			pstmt.setBigDecimal(5,new BigDecimal("56656192040") );
			
			
			pstmt.executeUpdate();
			pstmt.clearParameters();

			while (rs.next()) {
				int CompanyID = rs.getInt("CompanyID");
				String CompanyName = rs.getString("CompanyName");
				java.sql.Date SetUpDate = rs.getDate("SetUpDate");
				java.sql.Date PublicDate = rs.getDate("PublicDate");
				 
				BigDecimal RealCapital = rs.getBigDecimal("RealCapital");

				System.out.println(CompanyName + " : " + CompanyID+ ", 設立時間 "+ SetUpDate+ "；"+RealCapital+": "+ RealCapital+ "，"+ PublicDate);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("finish");

	}
}