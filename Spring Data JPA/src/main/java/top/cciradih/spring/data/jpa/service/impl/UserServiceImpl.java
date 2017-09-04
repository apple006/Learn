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
    public void merchandise(String payerName, String beneficiaryName, double amount) {
        User payer = repository.findByName(payerName);
        double payerBalance = payer.getBalance();

        if (payerBalance <= amount) {
            throw new RuntimeException("交易失败！" + payer.getName() + "余额不足！");
        } else if (payerName.equals(beneficiaryName)) {
            throw new RuntimeException("交易失败！用户名重复！");
        }

        User beneficiary = repository.findByName(beneficiaryName);
        double beneficiaryBalance = beneficiary.getBalance();

        payerBalance -= amount;
        beneficiaryBalance += amount;

        payer.setBalance(payerBalance);
        beneficiary.setBalance(beneficiaryBalance);

        repository.save(payer);
        repository.save(beneficiary);
    }
}
