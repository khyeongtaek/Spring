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

<h1>회원 정보 확인</h1>
<div>이메일: ${user.email}</div>
<div>프로필 이미지</div>
<div>
    <img src="${contextPath}/uploads/${user.filePath}/${user.filesystemName}" alt="프로필">

    ${contextPath}
    <br>
    ${user.filePath}
    <br>
    ${user.filesystemName}
</div>

</body>
</html>
