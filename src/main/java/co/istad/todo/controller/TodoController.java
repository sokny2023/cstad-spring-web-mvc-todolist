package co.istad.todo.controller;

import co.istad.todo.model.Todo;
import co.istad.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/todo")
    public String getAllTodoLists(Model model){
        List<Todo> todoList = todoService.getAllTodoList();
        model.addAttribute("todos", todoList);
        return "index";
    }

    @GetMapping("/todo/create")
    public String createNew(Model model){
        Todo todos = new Todo();
        model.addAttribute("todos",todos);
        return "create";
    }
    @PostMapping("/create")
    public String submitCreate(@ModelAttribute("todos") Todo todo){
        todoService.addTodoList(todo);
        return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/toggle-status")
    public String toggleTodoStatus(@PathVariable Long id) {
        todoService.toggleTodoStatus(id);
        return "redirect:/todo";
    }

}
