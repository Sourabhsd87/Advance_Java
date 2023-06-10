package dao;

import java.sql.Date;
import java.sql.SQLException;

import pojos.User;

public interface UserDao {
//add a method for user authentication(login)
	User authenticateUser(String email, String password) throws SQLException;
	
	//id | first_name | last_name | email | password | dob | status | role
	String RegisterUser(String Fname,String Lname,String email,String password,Date dob,String role) throws SQLException;
}
