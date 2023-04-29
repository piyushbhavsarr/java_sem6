<!DOCTYPE html>
<html>
<head>
	<title>Patient Details</title>
</head>
<body>
	<h1>Patient Details</h1>
	<table>
		<tr>
			<th>Patient No</th>
			<th>Patient Name</th>
			<th>Patient Address</th>
			<th>Patient Age</th>
			<th>Patient Disease</th>
		</tr>
		<%
			// Dummy data for patients
			String[][] patients = {
				{"001", "John Smith", "123 Main St", "35", "Flu"},
				{"002", "Jane Doe", "456 Elm St", "42", "Pneumonia"},
				{"003", "Bob Johnson", "789 Oak St", "28", "Broken Leg"},
				{"004", "Sally Jones", "321 Maple St", "19", "Appendicitis"},
				{"005", "Jim Brown", "654 Pine St", "57", "Heart Attack"}
			};

			// Loop through the patients array and display each patient's details in a row
			for (String[] patient : patients) {
				out.println("<tr>");
				out.println("<td>" + patient[0] + "</td>");
				out.println("<td>" + patient[1] + "</td>");
				out.println("<td>" + patient[2] + "</td>");
				out.println("<td>" + patient[3] + "</td>");
				out.println("<td>" + patient[4] + "</td>");
				out.println("</tr>");
			}
		%>
	</table>
</body>
</html>
