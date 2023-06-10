package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;


/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			userDao = new UserDaoImpl();
		} catch (SQLException e) {
			
			throw new ServletException("Error in init of "+getClass());
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		
		try {
			userDao.cleanUp();
		} catch (SQLException e) {
			System.out.println("Error in destroy of "+getClass());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter()){
			//pw.write("<h2>In register method</h2>");
			String Fname = request.getParameter("fnm");
			String Lname = request.getParameter("lnm");
			String Email = request.getParameter("mail");
			String Password = request.getParameter("pswd");
			String Bdate = request.getParameter("bd");
			LocalDate db = LocalDate.parse(Bdate);
			Date dob = Date.valueOf(Bdate);
			String role = request.getParameter("rl");
			int y = Period.between(db,LocalDate.now()).getYears();
			String result=null;
			if(y>21)
			{
			result = userDao.RegisterUser(Fname,Lname,Email,Password,dob,role);
			}
			pw.write("<h1>"+result+"<h1>");
 		} catch (SQLException e) {
 			
 			throw new ServletException("Error in do-post of "+getClass(),e); 
		}
	}

}
