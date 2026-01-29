package Alain.Alain.sDemo.service;

import Alain.Alain.sDemo.repository.TodoRepository;
import Alain.Alain.sDemo.models.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public Todo updateTodo(Long id, Todo data) {
        return todoRepository.save(data);
    }

    //DELETE TODO
    public void DeleteUser(Long userId) {
        todoRepository.deleteById(userId);
    }


    //    Pagination
    public Page<Todo> getAllTodosPages(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return todoRepository.findAll(pageable);
    }
}
