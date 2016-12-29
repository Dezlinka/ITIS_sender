<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Authorisation</title>
<%@include file="/jspf/header.jspf" %>
</head>
<body>
<%@include file="/jspf/navbar.jspf" %>
<form action="j_security_check" method="POST">
    Username: <input type="text" name="j_username" value="" size="15" /><br/><br/>
    Password: <input type="password" name="j_password" value="" size="15" /><br/><br/>
    <input type="submit" value="Login" />
</form>
</body>
</html>