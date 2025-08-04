<%--
  Created by IntelliJ IDEA.
  User: kht
  Date: 2025. 8. 4.
  Time: 오전 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="../layout/header.jsp">
    <jsp:param name="title" value="${board.bid}번 게시글"/>
</jsp:include>

<h1>Board Write</h1>

<form method="post" action="${contextPath}/board/write">

    <div>작성자: ${sessionScope.nickname}</div>
    <label>제목 <input type="text" name="title" autofocus> </label>
    <br>
    <textarea name="content"></textarea>
    <br>

    <button>등록</button>
</form>

</body>
</html>
