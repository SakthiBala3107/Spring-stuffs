package Alain.Alain.sDemo;

import Alain.Alain.sDemo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    // CREATE TODO
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo data) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoService.createTodo(data));
    }

    // GET TODO BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.getTodoById(id));
    }

    // GET ALL TODOS
    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.getTodos());
    }

    // UPDATE TODO
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable Todo id
//            @RequestBody Todo payload
    ) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(todoService.updateTodo(id));
    }

    // DELETE TODO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.DeleteUser(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
