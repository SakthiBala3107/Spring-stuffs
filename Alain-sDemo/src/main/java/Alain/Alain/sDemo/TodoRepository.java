package Alain.Alain.sDemo;

import org.springframework.stereotype.Component;

@Component
public class TodoRepository {

    String getAllTodos() {
        return "getAllTodos";
    }

    String accessUserbyId() {
        return "Accessed used by id";
    }

}


