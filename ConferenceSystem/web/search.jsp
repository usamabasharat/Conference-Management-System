<html>
<head>
<title>Information</title></head>
<%@ page language = "java" import="java.sql.*" %>
<body>
<%

String login_id = request.getParameter("id");

    Class.forName("com.mysql.jdbc.Driver");
   	
	
   	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");

	Statement stmt = con.createStatement();

	String query = "select * from candidate where USERNAME='" +login_id+ "' ";
	ResultSet rs=stmt.executeQuery(query);


if(rs.next()) {out.println(login_id+ " already taken.");}
else{out.println(login_id+ " is available.");}

stmt.close();
con.close();
%>

</body>
</html>