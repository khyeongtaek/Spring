<%--
  Created by IntelliJ IDEA.
  User: kht
  Date: 2025. 7. 28.
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="./layout/header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

<img src="${contextPath}/resources/image/img.png">


</body>
</html>
