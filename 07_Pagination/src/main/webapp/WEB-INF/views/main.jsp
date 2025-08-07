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
<a href="${contextPath}/user/list">회원 목록</a>
<br>
<a href="${contextPath}/notice/list">공지사항 목록</a>

<script type="text/javascript">
    const msg = "${msg}";
    if(msg !== '') {
        alert(msg);
    }

</script>



</body>
</html>
