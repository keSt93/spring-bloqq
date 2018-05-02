package bbsmt.bloqq.bloqq.repository;


import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqqRepository extends PagingAndSortingRepository<BloqqPost, Integer> {

    public BloqqPost findById(int id);

    public Iterable<BloqqPost> findFirst2ByOrderByIdDesc();
    public Iterable<BloqqPost> findAllByUserOrderByCreateDateDesc(User user);
    public Iterable<BloqqPost> findAllByOrderByCreateDateDesc();
    public Iterable<BloqqPost> findAllByUserAndIdNotOrderByCreateDateDesc(User user, int id);

    public int countAllBy();

}
