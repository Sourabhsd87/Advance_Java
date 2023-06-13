package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImplimentation;
import pojos.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value="/login",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImplimentation userDao;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		try {
			userDao=new UserDaoImplimentation();
		}
		catch(Exception e){
			throw new ServletException("error in init of "+getClass());
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			userDao.cleanup();
		}
		catch(Exception e)
		{
			System.out.println("Error in destroy of "+getClass());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		try(PrintWriter pw =response.getWriter())
		{
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			
			User user = userDao.authenticateUser(email, password);
			if(user == null)
			{
				pw.write("<h4>Invalid Email or password, please <a href='Login.html'>Retry</a></h4>");
			}
			else {
				
				if(user.getRole().equals("admin"))
				{
					response.sendRedirect("admin_page");
				}
				else {
					if(user.isStatus()){
						response.sendRedirect("logout");
					}else{
						response.sendRedirect("Candidate-list");
					}
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
