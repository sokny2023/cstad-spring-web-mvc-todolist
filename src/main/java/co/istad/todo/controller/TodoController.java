package co.istad.todo.controller;

import co.istad.todo.model.Todo;
import co.istad.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
