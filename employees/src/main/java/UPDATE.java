

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
 * Servlet implementation class UPDATE
 */
@WebServlet("/UPDATE")
public class UPDATE extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UPDATE() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
            Connection con = DatabaseConnection.initializeDatabase();
  
           
            String query = "update employee set DOB = '"+request.getParameter("dob")+"', DOJ = '"+request.getParameter("doj")+"',  "
            		+ "DOR = '"+request.getParameter("dor")+"',"
            				+ " Blood= '"+request.getParameter("blood")+"',"
            						+ "  Gen = '"+request.getParameter("gender")+"' "
            								+ "where Fname = '"+request.getParameter("fname")+"' "
            										+ "AND Mname = '"+request.getParameter("mname")+"' AND "
            												+ "Lname = '"+request.getParameter("lname")+"';";
  
            PreparedStatement st = con.prepareStatement(query);
            
            
            // to make changes in database
            st.executeUpdate();
  
            st.close();
            con.close();
  
            // to display the successful result
            PrintWriter out = response.getWriter();
            out.println("<html><body><b>Successfully UPDATED"
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
