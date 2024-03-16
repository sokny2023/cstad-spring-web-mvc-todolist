package co.istad.todo.service;

import co.istad.todo.model.Todo;
import co.istad.todo.repository.TodoListDataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        return todoListDataSource.searchById(id);
    }

    @Override
    public void addTodoList(Todo todo) {
        if (todoListDataSource != null) {
            List<Todo> todoList = todoListDataSource.getTodoList();
            if (!todoList.isEmpty()) {
                Todo lastTodo = todoList.get(todoList.size() - 1);
                todo.setId(lastTodo.getId() + 1);
            }
            else
                todo.setId(1);
            todo.setCreateAt(LocalDate.now());
            todoListDataSource.addTodoList(todo);
        }
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

    @Override
    public void toggleTodoStatus(Long id) {
        Todo todo = searchById(id.intValue());
        if (todo != null) {
            todo.setIsDone(!todo.getIsDone());
            updateTodo(todo);
        }
    }
}
