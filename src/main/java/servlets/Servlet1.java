package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Locale;

/**
 * Servlet implementation class Servlet1
 */
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String course,author;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // Message de bienvenue
        out.println("<html>");
        out.println("<head><title>Servlet Example</title></head>");
        out.println("<body>");
        out.println("<h1>Bienvenue sur cette servlet!</h1>");
        //String course = getServletConfig().getInitParameter("course");
        //String author = getServletConfig().getInitParameter("author");
        out.println("<p>Course: " + course + "</p>");
        out.println("<p>Auteur: " + author + "</p>");
     // URL de la requête
        out.println("<p>URL de la requête: " + request.getRequestURL() + "</p>");

        // Adresse IP du client
        String ipAddress = request.getRemoteAddr();
        out.println("<p>Adresse IP du client: " + ipAddress + "</p>");
        
     // e. Langues que le client est capable de comprendre
        Enumeration<Locale> locales = request.getLocales();
        out.println("<p>Langues que le client est capable de comprendre :</p>");
        out.println("<ul>");
        while (locales.hasMoreElements()) {
            Locale locale = locales.nextElement();
            out.println("<li>" + locale + "</li>");
        }
        out.println("</ul>");

        // f. Toutes les entêtes de la requête HTTP
        out.println("<p>Entêtes de la requête HTTP :</p>");
        out.println("<ul>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            out.println("<li>" + headerName + ": " + headerValue + "</li>");
        }
        out.println("</ul>");
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
	
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		
		author = config.getInitParameter("author");
		course =config.getInitParameter("course");
		System.out.println(getInitParameter(author));
		}

}
