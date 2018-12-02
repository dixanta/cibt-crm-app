<%-- 
    Document   : index
    Created on : Nov 29, 2018, 8:48:08 AM
    Author     : USER
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Spring Framework!</h1>
    <c:forEach var="course" items="${courses}">
        <li style="font-weight: bold">${course.name} (${course.fees})</li>
    </c:forEach>
    </body>
</html>
