<%--
  Created by IntelliJ IDEA.
  User: kht
  Date: 2025. 8. 1.
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
</head>
<body>

<h1>로긴 화면</h1>

<form action="${contextPath}/user/login" method="post">
    <input type="hidden" name="url" value="${url}">
    <label>이메일: <input type="text" name="email"></label>
    <br>
    <label>패스워드: <input type="password" name="password"></label>
    <button>로그인</button>
    <button type="button" onclick="onSignUp()">회원가입</button>

    <c:if test="${not empty error}">
        <div style="font-size: 12px; color:red;">${error}</div>
    </c:if>
</form>

<script type="text/javascript">
    function onSignUp() {
        location.href = "${contextPath}/user/signUp";
    }

</script>

</body>
</html>
