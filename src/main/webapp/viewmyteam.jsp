<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="special" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_to_view_my_team_players_page</h1>
<h1>${teamname} players are:</h1>

<% String msg=request.getParameter("msg");
	if(msg!=null){%>
	<h1>${msg}</h1>
	<%}
	else
	{%>
	<table border="1">
	<tr>
		<th>Player_name</th>
		<th>Player_role</th>
	</tr>
	<special:forEach var="player" items="${players}">
	<tr>
		<th>${player.getName()}</th>
		<th>${player.getRole()}</th>
	</tr>
	
	</special:forEach>
		
	
	</table>
		
	<%}
%>
<br><br>
<a href="viewTeamByName.jsp"><button>Back</button></a>

</body>
</html>