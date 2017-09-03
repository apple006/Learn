package top.cciradih.spring.rest.docs;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {
    @GetMapping("/hello")
    public Map<String, Object> getIndex() {
        Map<String, Object> data = new HashMap<>();
        data.put("response", "Hello, world!");
        return data;
    }

    @GetMapping("/user/{id}")
    public Map<String, Object> getUser(@PathVariable Long id) {
        User user = new User();
        user.setId(id);
        user.setName("Cciradih");
        user.setEmail("hidarichaochen@gmail.com");

        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        return data;
    }

    @GetMapping("/users")
    public Map<String, Object> getUsers() {
        List<User> users = new ArrayList<>();
        User user = new User();
        for (int i = 0; i < 3; i++) {
            user.setId((long) i);
            user.setName("Cciradih");
            user.setEmail("hidarichaochen@gmail.com");
            users.add(user);
        }

        Map<String, Object> data = new HashMap<>();
        data.put("users", users);
        return data;
    }

    @PostMapping("/user")
    public Map<String, Object> postUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setId(1L);
        user.setName(name);
        user.setEmail(email);

        Map<String, Object> data = new HashMap<>();
        data.put("user", user);
        return data;
    }
}
