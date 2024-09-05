

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class cafeinsert
 */
public class cafeinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cafeinsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String price=request.getParameter("price");
		String rating=request.getParameter("rating");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Dish@123");
			String Insert="insert into cafe(name,city,price,rating)values(?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(Insert);
			
			ps.setString(1,name);
			ps.setString(2,city);
			ps.setString(3, price);
			ps.setString(4,rating);
			
			ps.executeUpdate();
			
			out.println("<html>");
			out.println("<body align=center>");
			out.println("<h2> successful insert cafe data");
			out.println("<br><a href=\"details.jsp\">Show details</a>");
			out.println("</body>");
			out.println("</html>");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		}	
	}

