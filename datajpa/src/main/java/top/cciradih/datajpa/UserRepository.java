package top.cciradih.datajpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(Long id);

    List<User> findByName(String name);
}
