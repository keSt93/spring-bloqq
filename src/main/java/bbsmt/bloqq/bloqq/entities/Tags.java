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
    private Kommentar kommentar;

    @ManyToOne(cascade = CascadeType.ALL)
    private BloqqPost bloqqPost;

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

    public Kommentar getKommentar() {
        return kommentar;
    }

    public void setKommentar(Kommentar kommentar) {
        this.kommentar = kommentar;
    }

    public BloqqPost getBloqqPost() {
        return bloqqPost;
    }

    public void setBloqqPost(BloqqPost bloqqPost) {
        this.bloqqPost = bloqqPost;
    }
}
