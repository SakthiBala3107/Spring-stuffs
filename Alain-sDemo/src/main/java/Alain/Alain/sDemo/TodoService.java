package Alain.Alain.sDemo;

import Alain.Alain.sDemo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    //create Tod
    public Todo createTodo(Todo data) {
        return todoRepository.save(data);


    }

    //get by id
    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found!"));
    }

    //get all Todos
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    //UPDATE TODD

    public Todo updateTodo(Todo data) {
        return todoRepository.save(data);
    }

    //DELETE TODO
    public void DeleteUser(Long userId) {
        todoRepository.deleteById(userId);
    }

}
