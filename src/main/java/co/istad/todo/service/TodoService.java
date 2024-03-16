package co.istad.todo.service;

import co.istad.todo.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getAllTodoList();
    Todo searchById(Integer id);
    void addTodoList(Todo todo);
    void deleteById(Integer id);
    void updateTodo(Todo todo);
    List<Todo> searchTodoLists(String task, Boolean isDone);
}
