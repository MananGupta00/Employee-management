

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employees.DatabaseConnection;

/**
 * Servlet implementation class Retrieve
 */
@WebServlet("/Retrieve")
public class Retrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Retrieve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out = response.getWriter();
			try {
				Connection con = DatabaseConnection.initializeDatabase();
				PreparedStatement st = con.prepareStatement("select * from employee where Fname = "+request.getParameter("fname")+"");
				ResultSet rs = st.executeQuery();  
				out.println("<table border=1 width=50% height=50%>"); 
				 while (rs.next()) 
	             {  
	                 String n1 = rs.getString("Fname");  
	                 String n2 = rs.getString("Mname");
	                 String n3 = rs.getString("Lname");  
	                 String n4 = rs.getString("DOB");
	                 String n5 = rs.getString("DOJ");  
	                 String n6 = rs.getString("DOR");
	                 String n7 = rs.getString("Blood");  
	                 String n8 = rs.getString("Gen");  
	                 out.println("<tr><td>" + n1 + "</td><td>" + n2 + "</td><td>" + n3+ "</td><td>" + n4+ "</td><td>" + n5+ "</td><td>" + n6+ "</td><td>" + n7+ "</td><td>" + n8+ "</td></tr>");   
	             }  
				 out.println("</table>"); 
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
