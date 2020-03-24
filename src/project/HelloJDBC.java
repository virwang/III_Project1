package project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloJDBC {

	public static void main(String[] args) {
//			Connection connection = null;
		try (Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=JDBCDB",
				"wang", "1001");
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select*from emp");) {

			while (rs.next()) {
				String name = rs.getString("ename");
				int empno = rs.getInt("empno");
				String salary = rs.getString("salary");

				System.out.println(empno + " : " + name + ", " + salary);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("finish");

	}
}