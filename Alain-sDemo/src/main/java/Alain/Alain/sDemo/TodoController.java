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


    //Create user
    @PostMapping("/create")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo data) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoService.createTodo(data));
    }

    //Get user via id
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getUserById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodoById(id));
    }

    //    Get all Todos
    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getTodos());
    }


    //    update todo
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable Long id,
            @RequestBody Todo payload
    ) {
        return ResponseEntity.ok(todoService.updateTodo(id, payload));
    }

    //    delete todos
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.DeleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
