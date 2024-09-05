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
 * Servlet implementation class displayproduct
 */
public class displayproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayproduct() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();
				
				String name=request.getParameter("name");
				String price=request.getParameter("price");
				String prating=request.getParameter("prating");
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","Dish@123");
					String display="select * from product";
					PreparedStatement ps=con.prepareStatement(display);
						
					ResultSet rs = ps.executeQuery();
					out.println("Display all product");
					while(rs.next())
					{
						name=rs.getString(2);
						price=rs.getString(3);
						prating=rs.getString(4);
						
						String LinkUrl = "Detailsp?name=" +name+"&price="+price+"&prating="+prating;
						
						out.println("<html>");
						out.println("<body>");
						out.println("<a href='"+LinkUrl+"'>"+name+"</a><br>");
						out.println("</body>");
						out.println("</html>");
						
					}
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
