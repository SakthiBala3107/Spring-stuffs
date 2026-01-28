package Alain.Alain.sDemo;

import Alain.Alain.sDemo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface TodoRepository extends JpaRepository<Todo, Long> {



}


