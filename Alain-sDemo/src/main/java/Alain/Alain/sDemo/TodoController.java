package Alain.Alain.sDemo;

import Alain.Alain.sDemo.models.Todo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j

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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Todo fetched Successfully"),
            @ApiResponse(responseCode = "404", description = "Todo Not Found")
    })
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
        log.info("");
        log.warn("");
        log.debug("");
        return ResponseEntity.noContent().build();
    }

    //Pagination
    @GetMapping("/pages")
    ResponseEntity<Page<Todo>> getTodoPaged(@RequestParam int page, @RequestParam int size) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodosPages(page, size))
                ;
    }

}
