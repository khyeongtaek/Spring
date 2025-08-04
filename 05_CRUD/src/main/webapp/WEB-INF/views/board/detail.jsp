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
    <jsp:param name="title" value="${board.bid}번 게시글"/>
</jsp:include>

<h1>Board Detail</h1>

<div>작성자: ${board.user.nickname}</div>
<div>작성일자: ${board.createdAt}</div>
<div>수정일자: ${board.modifiedAt == null ? board.createdAt : board.modifiedAt}</div>
<hr>
<h1>${board.title}</h1>
<pre>${board.content}</pre>

<hr>

<button onclick="onModifyForm()">수정</button>

<script type="text/javascript">
    function onModifyForm() {
        location.href = "${contextPath}/board/modify?bid=${board.bid}";
    }

</script>


</body>
</html>
