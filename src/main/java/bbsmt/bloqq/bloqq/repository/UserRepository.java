package bbsmt.bloqq.bloqq.repository;

import bbsmt.bloqq.bloqq.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    public User findUserByUserName(String name);

    public User save(User user);

    public User findFirstUserByOrderByIdDesc();
}
