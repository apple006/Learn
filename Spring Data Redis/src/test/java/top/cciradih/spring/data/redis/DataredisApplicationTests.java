package top.cciradih.spring.data.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataredisApplicationTests {
    @Autowired
    private StringRedisTemplate template;
    @Autowired
    private HashMapping hashMapping;

    @Test
    public void valueOperations() {
        template.opsForValue().append("hello", "world");
    }

    @Test
    public void hash() {
//        User user = new User();
//        user.setId(1L);
//        user.setName("Cciradih");
//        user.setEmail("hidarichaochen@gmail.com");
//
//        hashMapping.writeHash("user",user);
        User user = hashMapping.loadHash("user");
        System.out.println(user.getName());
    }
}
