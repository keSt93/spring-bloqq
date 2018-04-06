package bbsmt.bloqq.bloqq.entities;


import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String tags;

    @ManyToOne(cascade = CascadeType.ALL)
    private Kommentar idKommentar;

    @ManyToOne
    private BloqqPost idBloqqPost;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Kommentar getIdKommentar() {
        return idKommentar;
    }

    public void setIdKommentar(Kommentar idKommentar) {
        this.idKommentar = idKommentar;
    }

    public BloqqPost getIdBloqqPost() {
        return idBloqqPost;
    }

    public void setIdBloqqPost(BloqqPost idBloqqPost) {
        this.idBloqqPost = idBloqqPost;
    }
}
