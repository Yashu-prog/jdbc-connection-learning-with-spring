import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC_Configuration {

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/StudentJDBC";
	private String user = "root";
	private String password = "yash1234";
	Connection con;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void startConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
	}

	public void closeConnection() throws SQLException {
		con.close();
	}

	public void getRecords() throws ClassNotFoundException, SQLException {
		startConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from student");
		while (rs.next()) {
			System.out.println("Roll number " + rs.getInt("id") + " " + rs.getString("name") + " age "
					+ rs.getInt("age") + " is in class " + rs.getInt("class") + "th.");
		}
		closeConnection();
	}

	public void deleteReocrd(int id) throws ClassNotFoundException, SQLException {
		startConnection();
		Statement stmt = con.createStatement();
		stmt.executeUpdate("delete from student where id =" + id);
		System.out.println("Reocrd for id " + id + " deleted successfully");
		closeConnection();
	}
}
