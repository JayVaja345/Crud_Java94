

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class edit
 */
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");	

		PrintWriter out=response.getWriter();
		out.println("Edit books");
		
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String city=request.getParameter("city");
		String price=request.getParameter("price");
		String rating=request.getParameter("rating");
		
		out.println("<html>");
		out.println("<body align=center>");
		out.println("<form action='editaction' method='post'>");
		out.println("<table>");
		out.println("<tr><td></td><td><input type='hidden' name='id' value='"+id+"''/></td></tr>");
		out.println("<tr><td> Cafe name:</td><td><input type='text' name='name' value='"+name+"''/></td></tr>");
		out.println("<tr><td> Cafe city:</td><td><input type='text' name='city' value='"+city+"''/></td></tr>");
		out.println("<tr><td> Cafe price:</td><td><input type='text' name='price' value='"+price+"''/></td></tr>");
		out.println("<tr><td> Cafe rating:</td><td><input type='text' name='rating' value='"+rating+"''/></td></tr>");
		out.println("<tr><td></td><td><input type='submit' name='submit' value='edit''/></td>");
		
		out.println("</table>");
		out.println("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
