package top.cciradih.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.cciradih.spring.data.jpa.entity.Transaction;

/**
 * @author hidarichaochen@gmail.com
 * @version 0.1
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
