<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>To-do List!</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
  <div class="container flex justify-content-center w-50">
    <div class="text-center">
      <h1>Welcome to your To-do List!</h1>
      <p>Click one of the buttons below:</p>
    </div>

    <div class="row justify-content-center text-center">
      <form action="${pageContext.request.contextPath}/add" class="flex-grow-1">
        <input type="submit" value="Add Task" class="btn btn-primary mb-3">
      </form>
      <form action="${pageContext.request.contextPath}/todos" class="flex-grow-1">
        <input type="submit" value="View Tasks" class="btn btn-info">
      </form>
    </div>
  </div>
</body>
</html>