<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="index.jsp">Back to main</a>
<br/>
<h1>Student list</h1>
<c:if test="${!empty listStudents}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Course</th>
            <th width="120">Rating</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listStudents}" var="student"></c:forEach>
        <tr>
            <td>${student.id}</td>
            <td>${student.studentName}</td>
            <td>${student.course}</td>
            <td>${student.rating}</td>
            <td><a href="<c:url value='/edit/${student.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove/${student.id}'/>">Delete</a></td>
        </tr>
    </table>
</c:if>



</body>
</html>
