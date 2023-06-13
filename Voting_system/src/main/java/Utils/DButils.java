package Utils;
import java.sql.*;

public class DButils {
	private static Connection cn;
	
	//open connection
	public static Connection openConnection() throws SQLException
	{
		String dburl="jdbc:mysql://localhost:3306/advjava?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn = DriverManager.getConnection(dburl, "root", "root123");
		return cn;
	}
	
	//close connection
	public static void closeConnection() throws SQLException
	{
		if(cn!=null)
		{
			cn.close();
		}
	}
}
