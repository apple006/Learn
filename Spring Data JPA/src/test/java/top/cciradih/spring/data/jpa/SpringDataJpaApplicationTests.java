package top.cciradih.spring.data.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaApplicationTests {
    @Autowired
    private UserRepository repository;

    @Test
    public void saveUser() {
        User user;
        for (int i = 0; i < 10; i++) {
            user = new User();
            user.setName("Cciradih" + i);
            user.setEmail("hidarichaochen@gmail.com" + i);
            user.setWebsite("http://cciradih.top");
            repository.save(user);
        }
    }

    @Test
    public void findUserByName() {
        User user = repository.findUserByName("Cciradih");
        System.out.println(user.getName());
    }

    @Test
    public void findAll() {
        Page<User> users = repository.findAll(new PageRequest(2, 5));
        System.out.println(users.getSize());
        List<User> userList = users.getContent();
    }
}
