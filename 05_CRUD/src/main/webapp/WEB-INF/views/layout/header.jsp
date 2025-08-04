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
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
          integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <title>${param.title}</title>
    <script type="text/javascript">
        const msg = "${msg}";
        if (msg !== "") alert(msg);
        function loginForm(){
            if(!location.href.includes("/user/login"))
                location.href = `${contextPath}/user/login?url=\${location.href}`;
            else
                location.href = `${contextPath}/user/login?`;

        }
    </script>
</head>
<body>

<h1>Hello World!</h1>

<c:if test="${empty sessionScope.nickname}">
    <div>
        <a href="javascript:loginForm()"><i class="fa-solid fa-arrow-right-from-bracket"></i>로그인</a>
    </div>
</c:if>
<c:if test="${not empty sessionScope.nickname}">
    <div>
        <a href="${contextPath}/user/myinfo">${sessionScope.nickname}</a>님 반갑습니다.
        <a href="${contextPath}/user/logout">로그아웃</a>
    </div>
</c:if>

<nav>
    <ul style="display: flex; list-style: none;">
        <li>
            <a href="${contextPath}/board/list">게시판</a>
        </li>
        <li>
            <a href="${contextPath}/board/list">게시시판</a>
        </li>
        <li>
            <a href="${contextPath}/board/list">게시시시판</a>
        </li>
        <li>
            <a href="${contextPath}/board/list">게시시시시판</a>
        </li>
        <li>
            <a href="${contextPath}/board/list">게시시시시시판</a>
        </li>

    </ul>
</nav>

