package bbsmt.bloqq.bloqq.repository;


import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.entities.Kommentar;
import bbsmt.bloqq.bloqq.entities.Tags;
import bbsmt.bloqq.bloqq.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tags, Integer> {

    public Iterable<Tags> getAllByKommentar(Kommentar kommentar);

}
