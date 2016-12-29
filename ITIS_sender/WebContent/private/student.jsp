<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css"
    href="/ITIS_sender/css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="/ITIS_sender/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="/ITIS_sender/js/jquery-ui-1.8.18.custom.min.js"></script>
<script src="/ITIS_sender/js/jqBootstrapValidation.js"></script>
<title>Student accepting</title>
<%@include file="/jspf/header.jspf" %>
</head>
<body>
 <script>
  $(function () { $("input,select,textarea").not("[type=submit]").jqBootstrapValidation(); } );
</script>
<%@include file="/jspf/navbar.jspf" %>

    <div class="container">

      <div class="starter-template">
    <script>
        $(function() {
            $('input[name=dob]').datepicker();
        });
    </script>

    <form  method="POST" action='InstituteController' name="frmAddUser">
        <div class="form-group">
        <p>¬ª¬ß¬Õ¬Ö¬Ü¬ã ¬Þ¬Ñ¬ã¬ã¬í ¬ä¬Ö¬Ý¬Ñ ¬Ò¬à¬Û¬è¬Ñ = <c:out value="${user.weight/(user.height/100*2)}" /></p>
        User ID : <input type="text" readonly="readonly" name="userid"
            value="<c:out value="${user.userid}" />" /> <br /> 
        First Name : <input class="form-control"
            type="text" name="firstName"
            value="<c:out value="${user.firstName}" />" /> <br /> 
        Last Name : <input class="form-control"
            type="text" name="lastName"
            value="<c:out value="${user.lastName}" />" /> <br /> 
        DOB : <input class="form-control"
            type="text" name="dob"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" />" /> <br /> 
            
        Email : <input class="form-control" type="text" name="email"
            value="<c:out value="${user.email}" />" /> <br /> 
           Height : <input class="form-control"
            type="text" name="height"
            value="<c:out value="${user.height}" />" /> <br /> 
            Weight : <input class="form-control"
            type="text" name="weight"
            value="<c:out value="${user.weight}" />" /> <br /> 
            Category(after medical check) : <input class="form-control"
            type="text" name="category"
            value="<c:out value="${user.category}" />" /> <br /> 
            The final decision:            
            <div class="control-group"><div class="controls"><input class="form-control"
            type="text" name="arms" required
            value="<c:out value="${user.arms}" />" /></div></div> <br /> 
            <button type="submit" class="btn btn-success" value="Submit">Submit</button>
            </div>
    </form>
    </div>

    </div>
</body>
</html>