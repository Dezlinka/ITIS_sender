<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<link type="text/css"href="/ITIS_sender/css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<title>Add new user</title>
<script type="text/javascript" src="/ITIS_sender/js/jquery-1.7.1.min.js"></script>
<script src="/ITIS_sender/js/jqBootstrapValidation.js"></script>
<%@include file="/jspf/header.jspf" %>

</head>
<body>
 <script>
  $(function () { $("input,select,textarea").not("[type=submit]").jqBootstrapValidation(); } );
</script>
<script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>
<%@include file="/jspf/navbar.jspf" %>

    <div class="container">

      <div class="starter-template">
    
   

    <form  method="POST" action='UserController' name="frmAddUser" class="form-horizontal">
        <div class="form-group">
        
        First Name : <div class="control-group"><div class="controls"><input class="form-control"
            type="text" name="firstName"  pattern="^[a-zA-Z]+$" required
            value="<c:out value="${user.firstName}" />" /></div></div> <br /> 
        Last Name : <div class="control-group"><div class="controls"><input class="form-control"
            type="text" name="lastName" required
            value="<c:out value="${user.lastName}" />" /></div></div> <br /> 
        DOB(MM/dd/yyyy) : <div class="control-group"><div class="controls"><input class="form-control"
            type="text" name="dob" required 
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /></div></div> <br /> 
            
        Email : <div class="control-group"><div class="controls"><input class="form-control" type="email" name="email"
            value="<c:out value="${user.email}" />" /></div></div> <br /> 
            Height :  <div class="control-group"><div class="controls"> <input class="form-control"
            type="number"  maxlength="3" name="height"
            value="<c:out value="${user.height}" />" /> </div></div><br /> 
            Weight : <input class="form-control"
            type="text" name="weight"
            value="<c:out value="${user.weight}" />" /> <br /> 
             Category(after medical check) : <div class="control-group"><div class="controls"><input class="form-control"
            type="text" name="category" required
            value="<c:out value="${user.category}" />" /> </div></div><br /> 
            <button type="submit" class="btn btn-success" value="Submit">Submit</button>
            
            </div>
    </form>
    
    </div>

    </div>
</body>
</html>