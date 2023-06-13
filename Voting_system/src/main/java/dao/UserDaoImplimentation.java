package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static Utils.DButils.*;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import pojos.User;

public class UserDaoImplimentation implements UserDao{

	private Connection cn;
	private PreparedStatement pst1;
	
	
	
	public UserDaoImplimentation() throws SQLException {
		super();
		this.cn = openConnection();
		this.pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		
	}
	
	public void cleanup() throws SQLException
	{
		if(pst1 != null)
		{
			pst1.close();
		}
		closeConnection();
	}



	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		pst1.setString(1, email);
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery())
		{
			if(rst.next())
				//int id, String firstName, String lastName,
				//String email, String password, Date dob,
				//boolean votingStatus, String role
				return new User(rst.getInt(1), rst.getString(2),rst.getString(3),email,password,rst.getDate(6),
						rst.getBoolean(7),rst.getString(8));
		}
		return null;
	}

}
