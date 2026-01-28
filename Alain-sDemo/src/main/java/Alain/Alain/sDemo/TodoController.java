package Alain.Alain.sDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")

public class TodoController {

    //
    @Autowired
    private TodoService todoService;

    @GetMapping("/get")
    public String todo() {

        todoService.getTodo();
        return "Todo";
    }

    @GetMapping("/access/DB")
    String accessDB() {
        return todoService.accessRepo();

    }


    //
    @GetMapping("/{id}")
    public String getTodoById(@PathVariable int id) {
        return String.valueOf(id);
    }

    @GetMapping
    public String getTodoByParam(@RequestParam("todoId") int id) {
        return String.valueOf(id);
    }

    @GetMapping("/createUser")
    public String createUser(@RequestParam("name") String name, @RequestParam("password") String password) {

        return "Name: " + name + " password: " + password;
    }

    @PostMapping("/create")
    public Object create(@RequestBody Object body) {
        return body;
    }

    @PutMapping("/{id}")
    public String updateUserById(@PathVariable int id) {
        return String.valueOf(id);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable int id) {
        return String.valueOf(id);
    }


//
}

