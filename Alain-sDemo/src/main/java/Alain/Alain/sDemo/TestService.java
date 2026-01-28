package Alain.Alain.sDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    String accessRepository() {
        return testRepository.getUserById();
    }

}
