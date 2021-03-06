package bbsmt.bloqq.bloqq.repository;


import bbsmt.bloqq.bloqq.entities.BloqqPost;
import bbsmt.bloqq.bloqq.entities.Kommentar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KommentarRepository extends CrudRepository<Kommentar, Integer> {
    public Kommentar save(Kommentar kommentar);

    public Iterable<Kommentar> getAllByBloqqPostOrderByCreationDateDesc(BloqqPost bloqqPost);

    public Kommentar getKommentarByBloqqPost(BloqqPost bloqqPost);

    public Iterable<Kommentar> getAllByBloqqPost(BloqqPost bloqqPost);
}
