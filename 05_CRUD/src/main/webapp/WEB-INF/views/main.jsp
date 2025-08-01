<%--
  Created by IntelliJ IDEA.
  User: kht
  Date: 2025. 7. 28.
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="redirectURL" value="${pageContext.request.requestURI}"/>
<html>
<head>
    <h1>Hello World</h1>
</head>
<body>
<a href="${contextPath}/user/login?redirectURL=${redirectURL}">로그인</a>


</body>
</html>
