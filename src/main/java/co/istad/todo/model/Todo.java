package co.istad.todo.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Todo {
    private Integer id;
    private String task;
    private String description;
    private Boolean isDone;
    private LocalDate createAt;
}
