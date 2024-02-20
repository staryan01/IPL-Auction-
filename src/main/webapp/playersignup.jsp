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
<h1>Welcome_to_Player_signup_page</h1>
<special:form action="playersignup" method="post" modelAttribute="player">
Name:<special:input path="name"/><br><br>
UserName:<special:input path="username"/><br><br>
Password:<special:input path="password"/><br><br>
Role:
<special:select path="role" id="xc">
<special:option value="">select</special:option>
<special:option value="Batsman">Batsman</special:option>
<special:option value="Bowler">Bowler</special:option>
<special:option value="Wicket_Keeper">Wicket_Keeper</special:option>
<special:option value="allrounder">All_Rounder</special:option>
</special:select><br><br>
Country:<special:input path="country"/><br><br>
Base_price:<special:input path="price"/><br><br>

<special:button>Signup</special:button><special:button type="reset">Cancel</special:button>

</special:form>


</body>
</html>