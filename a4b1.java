import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get the customer number from the request parameter
        String customerNumber = request.getParameter("customerNumber");

        // Set the content type of the response
        response.setContentType("text/html");

        // Get the writer object to write the response
        PrintWriter out = response.getWriter();

        // Try to connect to the database
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            // Prepare a statement to search for the customer
            String sql = "SELECT * FROM customer WHERE customerNumber=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, customerNumber);

            // Execute the query and get the result set
            ResultSet rs = stmt.executeQuery();

            // If the customer is found, display their details
            if (rs.next()) {
                out.println("<html><head><title>Customer Details</title></head><body>");
                out.println("<h1>Customer Details</h1>");
                out.println("<p>Customer Number: " + rs.getString("customerNumber") + "</p>");
                out.println("<p>Customer Name: " + rs.getString("customerName") + "</p>");
                out.println("<p>Contact Last Name: " + rs.getString("contactLastName") + "</p>");
                out.println("<p>Contact First Name: " + rs.getString("contactFirstName") + "</p>");
                out.println("<p>Phone: " + rs.getString("phone") + "</p>");
                out.println("<p>Address Line 1: " + rs.getString("addressLine1") + "</p>");
                out.println("<p>Address Line 2: " + rs.getString("addressLine2") + "</p>");
                out.println("<p>City: " + rs.getString("city") + "</p>");
                out.println("<p>State: " + rs.getString("state") + "</p>");
                out.println("<p>Postal Code: " + rs.getString("postalCode") + "</p>");
                out.println("<p>Country: " + rs.getString("country") + "</p>");
                out.println("<p>Sales Rep Employee Number: " + rs.getString("salesRepEmployeeNumber") + "</p>");
                out.println("<p>Credit Limit: " + rs.getString("creditLimit") + "</p>");
                out.println("</body></html>");
             } else {  
// If the customer is not found, display an error message
                          out.println("<html><head><title>Error</title></head><body>");
                          out.println("<h1>Error</h1>");
                          out.println("<p>Customer not found.</p>");
                          out.println("</body></html>");
                }
          } catch (SQLException e) {
// If an error occurs, display the error message
                out.println("<html><head><title>Error</title></head><body>");
                  out.println("<h1>Error</h1>");
                  out.println("<p>" + e.getMessage() + "</p>");
                  out.println("</body></html>");
          }
    }
}
