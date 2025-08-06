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

<h1>회원 정보 업로드</h1>
<form action="${contextPath}/user/signup" method="post" enctype="multipart/form-data" id="signupForm">

    <label>이메일: <input type="text" name="email"></label>
    <br>
    <input type="file" name="profile" id="profile">
    <br>

    <button>가입하기</button>

</form>
<c:if test="${not empty error}">
    <div style="font-size: 12px; color:red">${error}</div>
</c:if>
<hr>

<h1>회원 목록</h1>

<table border="1">
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><a href="${contextPath}/user/detail?uid=${user.uid}">${user.email}</a></td>
            <td>${user.originalFilename}</td>
        </tr>

    </c:forEach>
    </tbody>
</table>

<script type="text/javascript">
    const signupForm = document.getElementById('signupForm');
    const profile = document.getElementById('profile');
    signupForm.addEventListener('submit', function (e) {
        const file = profile.files[0];
        if (file) {
            const limit = 1024 * 1024 * 10;
            if (file.size > limit) {
                alert('첨부 파일 최대 크기는 10MB 입니다.');
                file.value = '';
                e.preventDefault();
                return;
            }
        }
    })

</script>
</body>
</html>
