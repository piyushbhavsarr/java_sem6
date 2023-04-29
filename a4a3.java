import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OnlineBookPurchase extends HttpServlet {

    // This method processes HTTP GET requests
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Get the session object
        HttpSession session = request.getSession();

        // Check if the user is logged in
        if (session.getAttribute("username") == null) {
            // If not logged in, redirect to the login page
            response.sendRedirect("login.jsp");
            return;
        }

        // Get the current page number from the session
        int page = 1;
        if (session.getAttribute("page") != null) {
            page = Integer.parseInt((String)session.getAttribute("page"));
        }

        // Get the price of the book from the session
        double price = 10.0;
        if (session.getAttribute("price") != null) {
            price = Double.parseDouble((String)session.getAttribute("price"));
        }

        // Calculate the total for the current page
        double pageTotal = page * price;

        // Set the page total in the session
        session.setAttribute("pageTotal", Double.toString(pageTotal));

        // Increment the page number in the session
        page++;
        session.setAttribute("page", Integer.toString(page));

        // Display the current page number and total
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Online Book Purchase</title></head>");
        out.println("<body>");
        out.println("<h1>Online Book Purchase</h1>");
        out.println("<p>Page Number: " + page + "</p>");
        out.println("<p>Page Total: $" + pageTotal + "</p>");

        // If this is the last page, calculate the total book and bill
        if (page > 10) {
            double total = pageTotal * 10;
            out.println("<p>Total Book: 10</p>");
            out.println("<p>Total Bill: $" + total + "</p>");
        }

        out.println("</body></html>");
    }

    // This method processes HTTP POST requests
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doGet(request, response);
    }

}
