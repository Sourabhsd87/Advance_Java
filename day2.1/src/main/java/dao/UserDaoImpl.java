package dao;

import java.sql.*;
import static utils.DBUtils.*;

import pojos.User;

public class UserDaoImpl implements UserDao {
	// fields
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	public UserDaoImpl() throws SQLException {
		// open conn
		cn = openConnection();
		pst1 = cn.prepareStatement("select * from users where email=? and password=?");
		//id | first_name | last_name | email | password | dob | status | role
		pst2 = cn.prepareStatement("insert into users values(default,?,?,?,?,?,?,?)");
		System.out.println("user dao created!");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		// set IN params
		pst1.setString(1, email);		
		pst1.setString(2, password);
		try(ResultSet rst=pst1.executeQuery()) {
			if(rst.next()) //=> success
				/*
				 * int id, String firstName, String lastName, String email, String password, Date dob,
			boolean votingStatus, String role
				 */
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, 
						rst.getDate(6), rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		closeConnection();
		System.out.println("user dao cleaned up!");
	}

	@Override
	public String RegisterUser(String Fname,String Lname,String email,String password,Date dob,String role) throws SQLException {
		System.out.println("in user reg");
		pst2.setString(1, Fname);
		pst2.setString(2, Lname);
		pst2.setString(3, email);
		pst2.setString(4, password);
		pst2.setDate(5,dob);
		pst2.setInt(6,0);
		pst2.setString(7, role);
		
		System.out.println("before execute update");

		 int rst2 = pst2.executeUpdate();
		
		System.out.println("lkjhgfds");
//		if(rst2==0) {
//			return "Error in registering User.";
//		}
		return "Successfully registered";
			
		
	}

}
