package top.cciradih.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.cciradih.spring.data.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
