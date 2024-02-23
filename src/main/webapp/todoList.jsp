<%@ page import="com.example.model.Todo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Todo List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5 text-center">
    <h1>Todo List</h1>

    <%
        List<Todo> todos = (List<Todo>) request.getAttribute("todos");

        if (todos == null || todos.isEmpty()) {
    %>
    <p>No To-Do items available.</p>
    <%
    } else {
    %>
    <div class="table-responsive">
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Estimated Time</th>
                <th>Done</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Todo todo : todos) {
            %>
            <tr>
                <td><%= todo.getId() %></td>
                <td><%= todo.getTitle() %></td>
                <td><%= todo.getDescription() %></td>
                <td><%= todo.getEstimated() %></td>
                <td><%= todo.isDone() ? "Yes" : "No" %></td>
                <td>
                    <form action="${pageContext.request.contextPath}/todos" method="post">
                        <input type="hidden" name="id" value="<%= todo.getId() %>">
                        <button type="submit" class="btn btn-success" <% if (todo.isDone()) { %>disabled<% } %>>Mark as Done</button>
                    </form>

                    <!-- Add a new form for delete button -->
                    <form action="${pageContext.request.contextPath}/deleteTodo" method="post">
                        <input type="hidden" name="id" value="<%= todo.getId() %>">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <%
        }
    %>
    <form action="${pageContext.request.contextPath}/index.jsp">
        <input type="submit" value="Back to Home" class="btn btn-secondary">
    </form>

    <form action="${pageContext.request.contextPath}/add">
        <input type="submit" value="Add Task" class="btn btn-primary">
    </form>
</div>
</body>
</html>