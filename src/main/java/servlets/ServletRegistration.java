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
 * Servlet implementation class ServletRegistration
 */
public class ServletRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistration() {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		request.getRequestDispatcher("/ServletErreur").forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/ServletErreur");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Récupérer les valeurs des champs saisis
        String firstName = request.getParameter("firstName");
        String familyName = request.getParameter("familyName");
        String email = request.getParameter("email");
        String[] topicInterest = request.getParameterValues("Topic");
        // Préparer une réponse HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Réponse de la Servlet Registration</title>");
        out.println("</head>");
        out.println("<body>");
        if (firstName != null && !firstName.isEmpty() &&
            familyName != null && !familyName.isEmpty() &&
            email != null && !email.isEmpty() && isValidEmail(email) &&
            topicInterest != null && topicInterest.length > 0) 
        {
        	
        
        out.println("<h2>Informations d'Inscription</h2>");
        out.println("<table border='1'>");
        out.println("<tr><th>Champ</th><th>Valeur</th></tr>");
        out.println("<tr><td>First Name</td><td>" + firstName + "</td></tr>");
        out.println("<tr><td>Family Name</td><td>" + familyName + "</td></tr>");
        out.println("<tr><td>Email</td><td>" + email + "</td></tr>");
        out.println("</table>");
        out.println("<p>Sujets d'intérêt :</p>");
        out.println("<ul>");
        for (String sujet : topicInterest) {
            out.println("<li>" + sujet + "</li>");
        }
        out.println("</ul>");
        }
        
        else
        	{
        	out.println("<h2>Erreur : Veuillez remplir tous les champs correctement.</h2>");
        	}
        out.println("</body>");
        out.println("</html>");
        }
	private boolean isValidEmail(String email) {
	    // Utilisation d'une expression régulière pour valider le format de l'adresse e-mail
	    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	    return email.matches(emailRegex);
	}
}
