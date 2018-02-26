<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Name</th>
        <th width="120">Course</th>
        <th width="120">Rating</th>
    </tr>
    <tr>
        <td>${student.id}</td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
</table>
</body>
</html>
