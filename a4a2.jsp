<%@page import="java.util.Date"%>
<%@page import="javax.servlet.http.Cookie"%>
<%@page import="javax.servlet.http.HttpSession"%>
<html>
  <head>
    <title>JSP Implicit Objects</title>
  </head>
  <body>
    <h1>JSP Implicit Objects Example</h1>

    <%
        // Use the "out" object to display current date and time
        out.print("Current Date and Time: " + new Date());

        // Use the "request" object to get header information
        out.print("<br>Header Information: " + request.getHeader("User-Agent"));

        // Use the "response" object to add a cookie
        Cookie cookie = new Cookie("username", "john");
        response.addCookie(cookie);
        out.print("<br>Cookie added successfully!");

        // Use the "config" object to get parameter values defined in <init-param>
        String value1 = getServletConfig().getInitParameter("param1");
        String value2 = getServletConfig().getInitParameter("param2");
        out.print("<br>Parameter 1 value: " + value1);
        out.print("<br>Parameter 2 value: " + value2);

        // Use the "application" object to get parameter values defined in <context-param>
        String appValue1 = getServletContext().getInitParameter("appParam1");
        String appValue2 = getServletContext().getInitParameter("appParam2");
        out.print("<br>Application Parameter 1 value: " + appValue1);
        out.print("<br>Application Parameter 2 value: " + appValue2);

        // Use the "session" object to display current session ID
        HttpSession session = request.getSession();
        out.print("<br>Current Session ID: " + session.getId());

        // Use the "pageContext" object to set and get attributes
        pageContext.setAttribute("myAttribute", "Hello World");
        String myAttr = (String)pageContext.getAttribute("myAttribute");
        out.print("<br>My Attribute Value: " + myAttr);

        // Use the "page" object to get the name of the generated servlet
        out.print("<br>Generated Servlet Name: " + page.getClass().getName());
    %>

  </body>
</html>
