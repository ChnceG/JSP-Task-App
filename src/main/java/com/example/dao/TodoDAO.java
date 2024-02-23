package com.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.model.Todo;
public class TodoDAO {
    private String url = "jdbc:mysql://localhost:3306/todo";
    private String username = "root";
    private String password = "";

    public TodoDAO() {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TodoDAO(String url, String username, String password) {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.url = url;
        this.username = username;
        this.password = password;
    }
    public List<Todo> list() {
        List<Todo> todos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM todo");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Todo todo = new Todo(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("estimated"),
                        rs.getBoolean("done")
                );
                todos.add(todo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return todos;
    }

    public void add(Todo todo) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO todo (title, description, estimated, done) VALUES (?, ?, ?, ?)")) {

            ps.setString(1, todo.getTitle());
            ps.setString(2, todo.getDescription());
            ps.setString(3, todo.getEstimated());
            ps.setBoolean(4, false);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Todo todo) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement("UPDATE todo SET title = ?, description = ?, estimated = ?, done = ? WHERE id = ?")) {

            ps.setString(1, todo.getTitle());
            ps.setString(2, todo.getDescription());
            ps.setString(3, todo.getEstimated());
            ps.setBoolean(4, todo.isDone());
            ps.setInt(5, todo.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement("DELETE FROM todo WHERE id = ?")) {

            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Todo getTodoById(int id) {
        Todo todo = null;

        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM todo WHERE id = ?")) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    todo = new Todo(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("estimated"),
                            rs.getBoolean("done")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todo;
    }
}