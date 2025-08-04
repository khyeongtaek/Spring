<%--
  Created by IntelliJ IDEA.
  User: kht
  Date: 2025. 8. 4.
  Time: 오전 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="../layout/header.jsp">
    <jsp:param name="title" value="Board게시판"/>
</jsp:include>

<h1>Board List</h1>
<caption>${boardCount}개 게시글이 있습니다.</caption>
<table border="1">
    <tbody>
    <c:forEach items="${boards}" var="board">
        <tr>
            <td><a href="${contextPath}/board/detail?bid=${board.bid}">${board.title}</a></td>
            <td>${board.user.nickname}</td>
            <td><fmt:formatDate value="${board.createdAt}" pattern="yyyy-MM-dd"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="${contextPath}/board/write">작성</a>



</body>
</html>
