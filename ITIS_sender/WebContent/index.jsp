<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome, student!</title>
<%@include file="/jspf/header.jspf" %>
</head>
<body>
<%@include file="/jspf/navbar.jspf" %>
    <div class="container">

      <div class="starter-template">
      <img src="img/students.jpg" class="img-fluid" alt="students" width="200">
        <h1>Ну здравствуй, рядовой.</h1>
        <p class="lead">Nice to meet you, new blood</p>
        <form action="UserController">
         <input type="hidden" name="action"   value="insert" />
        <button type="submit" class="btn btn-success">Insert data</button>
        </form>
        <br>
        <form action="ShowAllUsers">
         <input type="hidden" name="action"   value="Show" />
        
        </form>
        <blockquote class="blockquote">
  <p class="mb-0"><em>

</em>
</p>  
</blockquote>       
        <img src="img/logo.png" class="img-fluid" alt="logo" width="200">
              </div>
    </div>
</body>
</html>