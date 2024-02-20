<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to add amount page</h1>
<% int tid = Integer.parseInt(request.getParameter("tid")); %>
<form action="addamount" method="post">
Amount:<input type="text" name="wallet" placeholder="Enter your amount"><br><br>
<input type="text" name="tid" value="<%=tid%>" hidden="hidden"><br><br>
<button>ADD</button> <button type="reset">Cancel</button>

</form>

</body>
</html>