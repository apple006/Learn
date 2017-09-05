package top.cciradih.spring.data.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import top.cciradih.spring.data.jpa.entity.Transaction;
import top.cciradih.spring.data.jpa.entity.User;
import top.cciradih.spring.data.jpa.entity.UserEmail;
import top.cciradih.spring.data.jpa.repository.TransactionRepository;
import top.cciradih.spring.data.jpa.repository.UserRepository;
import top.cciradih.spring.data.jpa.service.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaApplicationTests {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository repository;
    @Autowired
    private UserService service;

    @Test
    public void saveUser() {
        for (int i = 0; i < 10; i++) {
            repository.save(new User("Cciradih" + i, "hidarichaochen@gmail.com" + i, "http://cciradih.top"));
        }

        User returnUser = repository.save(new User("Cciradih", "hidarichaochen@gmail.com", "http://cciradih.top"));
        logger.info("插入后返回：{}", returnUser);
    }

    @Test
    public void findByName() {
        User user = repository.findByName("Cciradih");
        logger.info("用户信息：{}", user);
    }

    @Test
    public void findAll() {
        int page = 0;
        int size = 5;


        // Sort 直接就可以用作排序对象。
        Sort sort = new Sort(Sort.Direction.DESC, "id");

        // PageRequest 实现了 Pageable 接口，可以用作分页对象。并且可以传入 Sort 对象进行排序。
        // 直接传入 Sort 对象会让排序在分页之前生效，比如 DESC 可以先逆序整个表的信息然后进行分页，查找出来的就是倒序分页。
        PageRequest pageRequest = new PageRequest(page, size, sort);

        // page 从0开始。
        // Page 继承自 Slice，所以也可以调用 Slice 的方法。
        Page<User> userPage = repository.findAll(pageRequest);

        logger.info("Page 接口：总数量（long）：{}", userPage.getTotalElements());
        logger.info("Page 接口：总页数（int）：{}", userPage.getTotalPages());
        logger.info("Slice 接口：第一个查询结果的 ID：{}", userPage.getContent().get(0).getId());
        logger.info("Slice 接口：最后一个查询结果的 ID：{}", userPage.getContent().get(size - 1).getId());
        logger.info("Slice 接口：结果集（List）:{}", userPage.getContent());
        logger.info("Slice 接口：查询数量（int）:{}", userPage.getSize());
        logger.info("Slice 接口：页码（int）:{}", userPage.getNumber());
        logger.info("Slice 接口：查询结果数量（List）:{}", userPage.getNumberOfElements());
        logger.info("Slice 接口：排序对象（Sort）:{}", userPage.getSort());

        // 不包含分页的排序
        List<User> userList = repository.findAll(new Sort(Sort.Direction.DESC, "id"));
        for (User user : userList) {
            logger.info("逆序结果集：{}", user);
        }
    }

    @Test
    public void onlyFindEmail() {
        // 通过接口来指定返回结果
        UserEmail userEmail = repository.findById(12L);
        logger.info("用户电子邮箱：{}", userEmail.getEmail());
    }

    @Test
    public void delete() {
        // 建议逻辑删除而不是物理删除
        repository.delete(11L);
    }

    @Test
    public void transactional() {
//        User user1 = new User("user1", "user1@gmail,com", "user1.com");
//        repository.save(user1);
//        User user2 = new User("user2", "user2@gmail,com", "user2.com");
//        repository.save(user2);
        try {
            String payerName = "user2";
            String beneficiaryName = "user1";
            double amount = 10.0;
            service.merchandise(payerName, beneficiaryName, amount);
            logger.info("交易成功！" + payerName + "支出" + amount + "，" + beneficiaryName + "收入" + amount + "。");
        } catch (RuntimeException e) {
            logger.info("{}", e.getMessage());
        }
    }

    @Test
    public void update() {

    }
}
