package top.cciradih.spring.data.jpa.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.cciradih.spring.data.jpa.entity.User;
import top.cciradih.spring.data.jpa.repository.UserRepository;
import top.cciradih.spring.data.jpa.service.UserService;

/**
 * @author hidarichaochen@gmail.com
 * @version 0.1
 */
@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void merchandise(String payer, String beneficiary, double amount) {
        User user1 = repository.findByName(payer);
        User user2 = repository.findByName(beneficiary);

        double balance1 = user1.getBalance();
        double balance2 = user2.getBalance();
        if (balance1 >= amount) {
            balance1 -= amount;
            balance2 += amount;

            user1.setBalance(balance1);
            user2.setBalance(balance2);

            repository.save(user1);
            repository.save(user2);
        } else {
            throw new RuntimeException(payer + "余额不足！");
        }
    }
}
