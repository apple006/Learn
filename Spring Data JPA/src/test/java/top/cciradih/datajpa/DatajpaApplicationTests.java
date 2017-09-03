package top.cciradih.datajpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DatajpaApplicationTests {
    @Autowired
    private UserRepository repository;

    @Test
    public void contextLoads() {
        System.out.println(repository.findById(1L));
        System.out.println(repository.findByName("Cciradih"));
    }
}
