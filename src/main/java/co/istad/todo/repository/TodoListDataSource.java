package co.istad.todo.repository;

import co.istad.todo.model.Todo;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Getter
public class TodoListDataSource implements TodoListRepository{
    private final List<Todo> todoList = new ArrayList<>();

    public TodoListDataSource(){
        todoList.add(new Todo(1,"Spring","Build Spring Web",true, LocalDate.now()));
        todoList.add(new Todo(2,"Front-end","Clone Website CSTAD",true, LocalDate.now()));
        todoList.add(new Todo(3,"Go to school","got to school for make project",false, LocalDate.now()));
        todoList.add(new Todo(4,"Sleep","Sleep at home",false, LocalDate.now()));
    }

    @Override
    public List<Todo> getAllTodoList() {
        return todoList;
    }

    @Override
    public Todo searchById(Integer id) {
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addTodoList(Todo todo) {
       todoList.add(todo);
    }

    @Override
    public void deleteById(Integer id) {
        todoList.removeIf(todo -> todo.getId().equals(id));
    }


    @Override
    public void updateTodo(Todo todo) {
        todoList.stream().filter(t->t.getId().equals(todo.getId()))
                .forEach(p-> {
                    p.setTask(todo.getTask());
                    p.setDescription(todo.getDescription());
                    p.setIsDone(todo.getIsDone());
                });
    }

    public List<Todo> searchDodoList(String task) {
        return todoList.stream()
                .filter(todo -> todo.getTask().toLowerCase().contains(task.toLowerCase())
                        || todo.getDescription().toLowerCase().contains(task.toLowerCase()))
                .collect(Collectors.toList());
    }

}
