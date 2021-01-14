import java.sql.SQLException;

public class School {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		JDBC_Configuration jconf = new JDBC_Configuration();
//		to fetch records
		jconf.getRecords();
//		to delete particular record
//		jconf.deleteReocrd(2);
	}
}