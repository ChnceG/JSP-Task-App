<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Task</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container d-flex flex-column align-items-center">
    <h1 class="text-center">Add New Task</h1>
    <div class="text-center justify-content-center">
        <form class="mx-auto" action="${pageContext.request.contextPath}/addTodo" method="post">
            <label>Title: <input type="text" name="title" class="form-control" required></label><br>
            <label>Description: <input type="text" name="description" class="form-control"></label><br>
            <label>Estimated: <input type="text" name="estimated" class="form-control"></label><br>
            <button type="submit" class="btn btn-primary btn-block mt-3">Add</button>
        </form>
    </div>

    <div class="w-50 mt-3 d-flex justify-content-between text-center">
        <form action="${pageContext.request.contextPath}/index.jsp" class="flex-grow-1">
            <input type="submit" value="Back to Home" class="btn btn-secondary btn-block">
        </form>

        <form action="${pageContext.request.contextPath}/todos" class="ml-2 flex-grow-1">
            <input type="submit" value="View Tasks" class="btn btn-info btn-block">
        </form>
    </div>
</div>
</body>
</html>
