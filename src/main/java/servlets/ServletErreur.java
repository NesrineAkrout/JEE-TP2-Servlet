package servlets;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletErreur
 */
public class ServletErreur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletErreur() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletContext();
        
        String adminName = context.getInitParameter("admin_name");
        String adminEmail = context.getInitParameter("admin_email");
        
        
       
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Message de bienvenue
        out.println("<html>");
        out.println("<head><title>Servlet Erreur</title></head>");
        out.println("<body>");
        out.println("<h1>An error has occurred. Please inform the administrator, "
        		+adminName +", at the email address "+adminEmail+"</h1>");
        out.println("</body>");
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
