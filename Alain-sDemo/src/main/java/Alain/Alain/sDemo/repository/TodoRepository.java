package Alain.Alain.sDemo.repository;

import Alain.Alain.sDemo.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TodoRepository extends JpaRepository<Todo, Long> {



}


