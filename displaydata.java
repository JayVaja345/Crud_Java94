

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
import java.sql.ResultSet;

/**
 * Servlet implementation class displaydata
 */
public class displaydata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displaydata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String price=request.getParameter("price");
		String rating=request.getParameter("rating");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Dish@123");
			String display="select * from cafe";
			PreparedStatement ps=con.prepareStatement(display);
			
			ResultSet rs = ps.executeQuery();
			out.println("Display all product");
			out.println("<html>");
			out.println("<body align=center>");
			out.println("<table>");
			
			while(rs.next())
			{
				String id=rs.getString(1);
				name=rs.getString(2);
				city=rs.getString(3);
				price=rs.getString(4);
				rating=rs.getString(5);
				
				String LinkUrl = "cdisplay?name=" +name+"&city="+city+"&price="+price+"&rating="+rating+"&id="+id;
				
				out.println("<tr");
				out.println("<td");
				out.println("<br><a href='"+LinkUrl+"'>"+name+"</a><br>");
				out.println("<td");
				out.println("<br><a href=\"cdisplay\">show details</a><br>");
				out.println("</tr>");		
			}
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
