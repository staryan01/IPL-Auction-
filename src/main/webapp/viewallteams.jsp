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

<h1>Welcome_to_view_all_teams</h1>
<h1>${msg}</h1>
<table border="1">
<tr>
	<th>Team_name</th>
	<th>Wallet</th>
	<th>Status</th>
	<th>Change_status</th>
	<th>Add_amount</th>
	<th>Team_players</th>
</tr>

<special:forEach var="team" items="${teams}">
<tr>
	<th>${team.getName() }</th>
	<th>${team.getWallet() }</th>
	<th>${team.isStatus() }</th>
	<th><a href="changestatus?tid=${team.getTid()}"><button>Change_status</button></a></th>
	<th><a href="addamount.jsp?tid=${team.getTid()}"><button>Add_amount</button></a></th>
	<th>Team_players</th>
</tr>
</special:forEach>

</table>
</body>
</html>