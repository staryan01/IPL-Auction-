<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%> <!-- to display the msg inside expression tag -->
            <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_to_view_Team_by_name_page</h1>
<h1>Select_Team</h1>
<form action="fetchbyusingteamname" method="post">
<select name="name">
<special:forEach var="team" items="${teams}">
<option value="${team.getName()}">${team.getName()}</option>
</special:forEach>
</select>
<button type="submit">Search</button><br><br>

</form>

<a href="managementHome.jsp"><button>Back</button></a>

</body>
</html>