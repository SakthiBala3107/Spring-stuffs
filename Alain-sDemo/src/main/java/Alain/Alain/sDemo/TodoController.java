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

    //
    @Autowired
    private TodoService todoService;

    //create new todo
    @PostMapping("/create")
    public ResponseEntity<Todo> createUser(@RequestBody Todo data) {
        return new ResponseEntity<>(todoService.createTodo(data), HttpStatus.CREATED);


    }

    //GetTod By id
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        try {

            return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }


    //Get all todos
    @GetMapping
    ResponseEntity<List<Todo>> getTodos() {
        try {
            return new ResponseEntity<List<Todo>>(todoService.getTodos(), HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }


    //update todo
    @PutMapping("/{id}")
    ResponseEntity<Todo> updateTodo(@RequestBody Todo userPayload) {
        return new ResponseEntity<>(todoService.updateTodo(userPayload), HttpStatus.OK);
    }

    //Delete Todo
    @DeleteMapping("/{id}")
    void deleteTodo(@PathVariable Long id){
        todoService.DeleteUser(id);
    }

}