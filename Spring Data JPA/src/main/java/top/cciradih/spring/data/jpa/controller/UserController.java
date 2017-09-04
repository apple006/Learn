package top.cciradih.spring.data.jpa.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.cciradih.spring.data.jpa.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserService service;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public Map<String, Object> getHello() {
        Map<String, Object> data = new HashMap<>();
        data.put("data", "hello");
        return data;
    }

    @GetMapping("/transactional")
    public Map<String, Object> getTransactional() {
        Map<String, Object> data = new HashMap<>();
        try {
            String payerName = "user2";
            String beneficiaryName = "user1";
            double amount = 10.0;
            service.merchandise(payerName, beneficiaryName, amount);
            logger.info("交易成功！" + payerName + "支出" + amount + "，" + beneficiaryName + "收入" + amount + "。");
            data.put("data", "交易成功！" + payerName + "支出" + amount + "，" + beneficiaryName + "收入" + amount + "。");
            return data;
        } catch (RuntimeException e) {
            logger.info("{}", e.getMessage());
            data.put("data", e.getMessage());
            return data;
        }
    }
}
