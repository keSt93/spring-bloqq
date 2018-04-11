package bbsmt.bloqq.bloqq.repository;


import bbsmt.bloqq.bloqq.entities.Kommentar;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KommentarRepository extends CrudRepository<Kommentar, Integer> {
    public Kommentar save(Kommentar kommentar);

}
