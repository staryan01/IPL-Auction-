<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to main signup page</h1>

<form action="signup" method="post">
<h1>Choose_Your_Role</h1>
<input type="radio" name="role" value="Management">Management<br><br>
<input type="radio" name="role" value="Team">Team<br><br>
<input type="radio" name="role" value="Player">Player<br><br>
<button>Submit</button><br>

</form>
<a href="LoginArea.jsp">Already account is existed</a>

</body>
</html>