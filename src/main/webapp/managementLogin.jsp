<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome_to_login_page</h1>
<form action="managementlogin" method="post">
Username:<input type="text" name="name" placeholder="Enter your Username"><br><br> <!-- in mvc technology we should always take the attribute or paramenter same -->
Password:<input type="password" name="password" placeholder="Enter your Password"><br><br>
<button type="submit">Login</button><button type="reset">Cancel</button>
</form>

</body>
</html>