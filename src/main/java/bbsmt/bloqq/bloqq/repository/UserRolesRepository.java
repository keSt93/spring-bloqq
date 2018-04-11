package bbsmt.bloqq.bloqq.repository;


import bbsmt.bloqq.bloqq.entities.User;
import bbsmt.bloqq.bloqq.entities.UserRoles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends CrudRepository<UserRoles, Integer> {

    public UserRoles save(UserRoles userRoles);

}
