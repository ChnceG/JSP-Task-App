package com.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.example.dao.TodoDAO;
import com.example.model.Todo;

@WebServlet(name = "TodoServlet", value = "/todos")
public class TodoServlet extends HttpServlet {
    private TodoDAO todoDAO;

    @Override
    public void init() {
        // Initialize TodoDAO here (either use DI framework or manual instantiation)
        todoDAO = new TodoDAO("jdbc:mysql://localhost:3306/todo", "root", "");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        if ("/add".equals(action)) {
            // Forward to the addTodo.jsp page for adding new tasks
            request.getRequestDispatcher("/addTodo.jsp").forward(request, response);
        } else {
            // Handle GET requests for viewing all tasks
            List<Todo> todos = todoDAO.list();
            request.setAttribute("todos", todos);
            request.getRequestDispatcher("/todoList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String action = request.getServletPath();

        if ("/deleteTodo".equals(action)) {
            // Handle deleting a task
            int taskId = Integer.parseInt(request.getParameter("id"));
            todoDAO.delete(taskId);
            // Redirect back to the todos page
            response.sendRedirect(request.getContextPath() + "/todos");
        } else if ("/addTodo".equals(action)) {
            // Handle adding a new task
            Todo newTodo = new Todo(
                    request.getParameter("title"),
                    request.getParameter("description"),
                    request.getParameter("estimated"),
                    false // Assuming initially not done
            );

            todoDAO.add(newTodo);

            // Redirect back to the todos page
            response.sendRedirect(request.getContextPath() + "/todos");
        } else if ("/todos".equals(action)) {
            // Handle marking tasks as done
            int taskId = Integer.parseInt(request.getParameter("id"));
            // ...
        }
    }
}
