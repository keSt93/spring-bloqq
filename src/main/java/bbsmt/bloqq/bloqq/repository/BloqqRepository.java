package bbsmt.bloqq.bloqq.repository;


import bbsmt.bloqq.bloqq.entities.BloqqPost;
import org.springframework.data.repository.CrudRepository;

public interface BloqqRepository extends CrudRepository<BloqqPost, Integer> {
}
