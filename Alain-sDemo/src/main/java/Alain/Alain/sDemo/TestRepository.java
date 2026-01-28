package Alain.Alain.sDemo;


import org.springframework.stereotype.Component;

@Component
public class TestRepository {

    String getUserById() {
        return "this method returrn user from DB via ID";
    }


}


