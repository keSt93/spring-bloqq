package bbsmt.bloqq.bloqq.repository;


import bbsmt.bloqq.bloqq.entities.BloqqPost;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BloqqRepository extends PagingAndSortingRepository<BloqqPost, Integer> {

    public BloqqPost findById(int id);

    public BloqqPost findFirstByOrderByIdDesc();
}
