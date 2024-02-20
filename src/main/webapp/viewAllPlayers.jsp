<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${msg}</h1>
<h1>Welcome_to_view_all_Players_page</h1>
<table border="1">
<tr>
	<th>Player_Name</th>
	<th>Role</th>
	<th>Country</th>
	<th>Base_Price</th>
	<th>Status</th>
	<th>Change_Status</th>
</tr>

<special:forEach var="player" items="${players}">
<tr>
	<th>${player.getName()}</th>
	<th>${player.getRole()}</th>
	<th>${player.getCountry()}</th>
	<th>${player.getPrice()}</th>
	<th>${player.getStatus()}</th>
	<th><a href="changeplayerstatus?id=${player.getId()}"><button>Change_status</button></a></th>
	
</tr>
</special:forEach>

</table><br><br>
<a href="managementHome.jsp"><button>Back</button></a>
</body>
</html>