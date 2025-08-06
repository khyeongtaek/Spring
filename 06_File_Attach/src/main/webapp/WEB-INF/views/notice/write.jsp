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

<h1>공지사항 작성하기</h1>
<form action="${contextPath}/notice/write" method="post" enctype="multipart/form-data" id="writeForm">

    <label>제목: <input type="text" name="title"></label>
    <br>
    <textarea name="content"></textarea>
    <br>
    <input type="file" name="files" id="files" multiple>
    <br>

    <button>하기</button>

</form>


</body>
</html>
