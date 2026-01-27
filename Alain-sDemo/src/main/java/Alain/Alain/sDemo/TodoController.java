package Alain.Alain.sDemo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @GetMapping("/get")
    String Todo(){
        return "Toda";
    }

//    path variable
    @GetMapping("/{id}")
    String getTodoById(@PathVariable int id){
      return String.valueOf(id);
    }

    //request param

    @GetMapping
    String getTodoByParam(@RequestParam("todoId") int id){
        return String.valueOf(id);
    }

    @GetMapping("/create")
    String createUser(@RequestParam("name" ) String name, @RequestParam("password") String password){
        return "Name:" +name+"password:" + password;
    }
}
