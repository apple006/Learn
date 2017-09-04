package top.cciradih.spring.data.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.cciradih.spring.data.jpa.entity.User;
import top.cciradih.spring.data.jpa.entity.UserEmail;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);

    UserEmail findById(Long id);
}
