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
    <title>Title</title>
</head>
<body>

<h1>회원 목록</h1>

<a href="${contextPath}/user/list?sort=DESC">최신순</a>
<a href="${contextPath}/user/list?sort=ASC">과거순</a>
<select onchange="location.href='${contextPath}/user/list?size='+this.value">
    <option value="20" ${param.size == '20' ? 'selected' : ''}>20</option>
    <option value="50" ${param.size == '50' ? 'selected' : ''}>50</option>
    <option value="100" ${param.size == '100' ? 'selected' : ''}>100</option>
</select>


<table border="1">
    <tbody>
    <c:forEach items="${users}" var="user" varStatus="stat">
        <tr>
            <td>${stat.count}</td>
            <td>${user.lastName}</td>
            <td>${user.firstName}</td>
            <td>${user.email}</td>
            <td>${user.gender}</td>
            <td>${user.ipAddress}</td>
        </tr>
    </c:forEach>
    </tbody>
    <tfoot>
    <tr>
        <td colspan="6">${pagingHtml}</td>
    </tr>
    </tfoot>

</table>


</body>
</html>
