

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class cdisplay
 */
public class cdisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cdisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String price=request.getParameter("price");
		String rating=request.getParameter("rating");
		
		String deleteUrl = "delete?id=" +id;
		String editUrl = "edit?id=" +id+"&name="+name+"&city="+city+"&price="+price+"&rating="+rating;
		
		out.println("<html>");
		out.println("<body align=center>");
		out.println("<h2>Cafe's Details</h2>");
		out.println("<br>Cafe's Name:  "+name);
		out.println("<br>Cafe's city:  "+city);
		out.println("<br>For two person:  "+price);
		out.println("<br>Cafe's Rate:  "+rating);
		
		out.println("<br><br><a href='"+deleteUrl+"'>"+"Delete"+"</a><br>");
		out.println("<br><a href='"+editUrl+"'>"+"Edit"+"</a><br>");
		
//		out.println("<br><a href=\"cafe.jsp\">Show details</a>");
		out.println("</body");
		out.println("</html>");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
