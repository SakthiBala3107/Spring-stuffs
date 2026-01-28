package Alain.Alain.sDemo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    long id;


    String title;
    String description;
    boolean isCompleted;
}
