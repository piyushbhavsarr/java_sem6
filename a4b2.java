import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SubjectServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Get the selected subject from the request parameter
        String selectedSubject = request.getParameter("subject");

        // Get the existing cookies for this client
        Cookie[] cookies = request.getCookies();

        // Check if the cookie for the selected subject already exists
        boolean cookieExists = false;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("subject") && cookie.getValue().equals(selectedSubject)) {
                    cookieExists = true;
                    break;
                }
            }
        }

        // If the cookie doesn't exist, create a new one and add it to the response
        if (!cookieExists) {
            Cookie subjectCookie = new Cookie("subject", selectedSubject);
            response.addCookie(subjectCookie);

            // Send a message back to the client
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Subject Selection</title></head><body>");
            out.println("<h1>Subject selected:</h1>");
            out.println("<p>" + selectedSubject + "</p>");
            out.println("</body></html>");
        } else {
            // If the cookie already exists, display an error message
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><head><title>Error</title></head><body>");
            out.println("<h1>Error</h1>");
            out.println("<p>A cookie for this subject has already been set.</p>");
            out.println("</body></html>");
        }
    }
}
