<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="special" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to management signup</h1>
<special:form action="managementsignup" method="post" modelAttribute="management">
	<h2>Name: <special:input path="name"/> </h2>
	<h2>Password: <special:input path="password"/> </h2>
	<special:button>Signup</special:button><special:button type="reset">Cancel</special:button>
	
</special:form>

</body>
</html>