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

<h1>${notice.title}</h1>
<h4>첨부 파일</h4>
<c:forEach items="${attaches}" var="attach">
    <div><a class="download-link" href="${contextPath}/notice/download?aid=${attach.aid}">${attach.originalFilename}</a>
    </div>
</c:forEach>
<pre>${notice.content}</pre>
<button onclick="onDelete()">삭제</button>
<script type="text/javascript">
    function onDelete() {
        location.href = "${contextPath}/notice/remove?nid=${notice.nid}";
    }



</script>
</body>
</html>
