package top.cciradih.spring.data.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;
import top.cciradih.spring.data.jpa.entity.Transaction;
import top.cciradih.spring.data.jpa.entity.User;
import top.cciradih.spring.data.jpa.repository.TransactionRepository;
import top.cciradih.spring.data.jpa.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJpaApplicationTests {
    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(SpringDataJpaApplicationTests.class);

    @Test
    public void contextLoads() {
    }

    @Test
    public void testUserRepository() {
//        // 保存并返回
//        User saveReturnUser = userRepository.save(new User("Cciradih", "hidarichaochen@gmail.com"));
//        logger.info("{}", saveReturnUser);

//        // 批量保存
//        List<User> userList = new ArrayList<>();
//        User user2;
//        for (int i = 0; i < 10; i++) {
//            user2 = new User("Cciradih" + i, "hidarichaochen@gmail.com" + i);
//            userList.add(user2);
//        }
//        List<User> saveReturnUserList = userRepository.save(userList);
//        for (User user : saveReturnUserList) {
//            logger.info("{}", user);
//        }

//        // 根据主键查询一个并返回
//        User findReturnUser = userRepository.findOne(1L);
//        logger.info("{}", findReturnUser);

//        // 查询全部
//        List<User> findReturnUserList1 = userRepository.findAll();
//        logger.info("{}", findReturnUserList1);

//        // 根据 id 字段查询并排序，默认是顺序
//        List<User> findReturnUserList2 = userRepository.findAll(new Sort("id"));
//        logger.info("{}", findReturnUserList2);
//        // 根据 id 字段倒序查询
//        List<User> findReturnUserList3 = userRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
//        logger.info("{}", findReturnUserList3);

//        // 范例查询
//        User user = new User("Cciradih", "hidarichaochen@gmail.com");
//        // 1.使用 Example
//        // 创建 Example
//        Example<User> userExample = Example.of(user);
//        User findExampleReturnUser = userRepository.findOne(userExample);
//        logger.info("{}", findExampleReturnUser);
//        // 2.使用 ExampleMatcher
//        // 创建 ExampleMatcher
//        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
//                // 忽略 balance 字段
//                .withIgnorePaths("id", "createTime")
//                // 忽略大小写
//                .withIgnoreCase()
//                // 忽略为空字段
//                .withIgnoreNullValues();
//        userExample = Example.of(user, exampleMatcher);
//        User findExampleWithExampleMatcherReturnUser = userRepository.findOne(userExample);
//        logger.info("{}", findExampleWithExampleMatcherReturnUser);

//        // 分页查询
//        Page<User> findPageReturnUser = userRepository.findAll(new PageRequest(0, 5));
//        List<User> findPageReturnUserList = findPageReturnUser.getContent();
//        long totalElements = findPageReturnUser.getTotalElements();
//        long totalPages = findPageReturnUser.getTotalPages();
//        int size = findPageReturnUser.getSize();
//        logger.info("\nTotalElements:{}\nTotalPages:{}\nFindPageReturnUserList:{}\nSize:{}", totalElements, totalPages, findPageReturnUserList, size);
//        findPageReturnUser.getTotalElements();

//        // 根据主键删除
//        userRepository.delete(1L);

//        // 删除全部
//        userRepository.deleteAll();

//        // 批量删除全部
//        userRepository.deleteAllInBatch();

//        // 根据对象删除
//        User user = new User("Cciradih", "hidarichaochen@gmail.com");
//        userRepository.delete(user);

//        // 根据对象批量删除
//        List<User> userList = new ArrayList<>();
//        User user2;
//        for (int i = 0; i < 10; i++) {
//            user2 = new User("Cciradih" + i, "hidarichaochen@gmail.com" + i);
//            userList.add(user2);
//        }
//        userRepository.delete(userList);
//        userRepository.deleteInBatch(userList);

//        // 统计数量
//        long countReturnUser = userRepository.count();
//        logger.info("{}", countReturnUser);

//        // 是否存在
//        boolean exists = userRepository.exists(34L);
//        logger.info("{}", exists);
    }
}
