package co.istad.todo.repository;

import co.istad.todo.model.Todo;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
@Getter
public class TodoListDataSource implements TodoListRepository{
    private List<Todo> todoList = new ArrayList<>();

    public TodoListDataSource(){
        todoList.add(new Todo(1,"Spring","Build Spring Web",false, LocalDate.now()));
        todoList.add(new Todo(2,"Front-end","Clone Website CSTAD",false, LocalDate.now()));
    }

    @Override
    public List<Todo> getAllTodoList() {
        return todoList;
    }

    @Override
    public Todo searchById(Integer id) {
        return null;
    }

    @Override
    public void addTodoList(Todo todo) {
       todoList.add(todo);
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
