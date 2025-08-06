<%--
  Created by IntelliJ IDEA.
  User: kht
  Date: 2025. 8. 5.
  Time: 오후 3:07
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
    <title>Title</title>
</head>
<body>

<a href="${contextPath}/notice/write">작성</a>
<hr>
<h1>공지사항</h1>

<table border="1">
    <tbody>
    <c:forEach items="${notices}" var="notice">
        <tr>
            <td><a href="${contextPath}/notice/detail?nid=${notice.nid}">${notice.title}</a></td>
            <td>
                <c:if test="${notice.attachCount ne 0}">
                    <i class="fa-solid fa-paperclip"></i>
                    ${notice.attachCount}
                </c:if>
                <c:if test="${notice.attachCount eq 0}">
                    -
                </c:if>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
