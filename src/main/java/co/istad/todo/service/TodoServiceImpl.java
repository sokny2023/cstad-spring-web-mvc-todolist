package co.istad.todo.service;

import co.istad.todo.model.Todo;
import co.istad.todo.repository.TodoListDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoListDataSource todoListDataSource;
    @Override
    public List<Todo> getAllTodoList() {
        return todoListDataSource.getAllTodoList();
    }

    @Override
    public Todo searchById(Integer id) {
        return null;
    }

    @Override
    public void addTodoList(Todo todo) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void updateTodo(Todo todo) {

    }

    @Override
    public List<Todo> searchTodoLists(String task, Boolean isDone) {
        return null;
    }
}
