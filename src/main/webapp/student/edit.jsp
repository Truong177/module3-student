<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <h1>Edit Student</h1>
    <p>
        <c:if test='${requestScope["message"] != null}'>
            <span class="text-danger">${requestScope["message"]}</span>
        </c:if>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/student" class="btn btn-secondary">Back to student list</a>
    </p>
    <form method="post" action="${pageContext.request.contextPath}/student">
        <input type="hidden" name="action" value="edit">
        <input type="hidden" name="id" value="${student.id}">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" name="name" value="${student.name}" required>
        </div>
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input type="text" class="form-control" id="address" name="address" value="${student.address}" required>
        </div>
        <div class="mb-3">
            <label for="point" class="form-label">Point</label>
            <input type="number" class="form-control" id="point" name="point" value="${student.point}" min="0" max="10" required>
        </div>
        <div class="mb-3">
            <label for="classroom" class="form-label">Classroom</label>
            <select class="form-select" id="classroom" name="classroom" required>
                <c:forEach var="classroom" items="${classrooms}">
                    <option value="${classroom.id}" <c:if test="${classroom.id == student.idClass}">selected</c:if>>
                            ${classroom.name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Update Student</button>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
