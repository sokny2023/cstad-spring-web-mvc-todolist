package co.istad.todo.repository;

import co.istad.todo.model.Todo;

import java.util.List;

public interface TodoListRepository {

    List<Todo> getAllTodoList();
    Todo searchById(Integer id);
    void addTodoList(Todo todo);
    void deleteById(Integer id);
    void updateTodo(Todo todo);
}
