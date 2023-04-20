

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import employees.DatabaseConnection;

/**
 * Servlet implementation class ADD
 */
@WebServlet("/ADD")
public class ADD extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ADD() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
            Connection con = DatabaseConnection.initializeDatabase();
  
           
            PreparedStatement st = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?);");
  
            // Preparing query for all the attributes
            st.setString(1, request.getParameter("fname"));
            st.setString(2, request.getParameter("mname"));
            st.setString(3, request.getParameter("lname"));
            st.setString(4, request.getParameter("dob"));
            st.setString(5, request.getParameter("doj"));
            st.setString(6, request.getParameter("dor"));
            st.setString(7, request.getParameter("blood"));
            st.setString(8, request.getParameter("gender"));
            
            
            // to make changes in database
            st.executeUpdate();
  
            st.close();
            con.close();
  
            // to display the successful result
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>");
        }
        catch (Exception e) {
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
