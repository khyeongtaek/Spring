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

<h1>Board Modify</h1>

<form method="post" action="${contextPath}/board/modify">

    <div>작성자: ${sessionScope.nickname}</div>
    <label>제목 <input type="text" name="title" autofocus value="${board.title}"> </label>
    <br>
    <textarea name="content">${board.content}</textarea>
    <br>

    <input type="hidden" name="bid" value="${board.bid}">
    <button>수정</button>
</form>


<button onclick="onDelete()">삭제</button>

<script type="text/javascript">
    function onDelete() {
        if (confirm("현재 게시글을 삭제할까요?")) {
            location.href = "${contextPath}/board/delete?bid=${board.bid}";
        }
    }
</script>

</body>
</html>
