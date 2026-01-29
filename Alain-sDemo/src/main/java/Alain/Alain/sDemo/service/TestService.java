package Alain.Alain.sDemo.service;

import Alain.Alain.sDemo.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

//    String accessRepository() {
//        return testRepository.getUserById();
//    }

}
