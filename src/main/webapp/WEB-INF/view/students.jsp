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
        <c:forEach items="${listStudents}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.studentName}</td>
            <td>${student.course}</td>
            <td>${student.rating}</td>
            <td><a href="<c:url value='/edit/${student.id}'/>">Edit</a></td>
            <td><a href="<c:url value='/remove/${student.id}'/>">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a student</h1>
<c:url var="addAction" value="/students/add"/>

<form:form action="${addAction}" commandName="student">
    <table>
        <c:if test="${!empty student.studentName}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="studentName">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="studentName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="course">
                    <spring:message text="course"/>
                </form:label>
            </td>
            <td>
                <form:input path="course"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="rating">
                    <spring:message text="rating"/>
                </form:label>
            </td>
            <td>
                <form:input path="rating"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty student.studentName}">
                    <input type="submit"
                           value="<spring:message text="Edit student"/>"/>
                </c:if>
                <c:if test="${empty student.studentName}">
                    <input type="submit"
                           value="<spring:message text="Add student"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
