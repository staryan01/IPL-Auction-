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
<h1>Welcome_to_Buy_Players_page</h1>
<table border="1">
<tr>
	<th>Player_Name</th>
	<th>Role</th>
	<th>Country</th>
	<th>Base_Price</th>
	<th>Status</th>
	<th>Buy_Player</th>
</tr>

<special:forEach var="player" items="${players}">
<tr>
	<th>${player.getName()}</th>
	<th>${player.getRole()}</th>
	<th>${player.getCountry()}</th>
	<th>${player.getPrice()}</th>
	<th>${player.getStatus()}</th>
	<th><a href="buyplayer?id=${player.getId()}"><button>Buy_Player</button></a></th>
	<!--  <th>Team_players</th> -->
</tr>
</special:forEach>
</table>

</body>
</html>