package bbsmt.bloqq.bloqq.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kommentar")
public class Kommentar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String kommentar;

    @Column
    private Date creationDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private BloqqPost bloqqPost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKommentar() {
        return kommentar;
    }

    public void setKommentar(String kommentar) {
        this.kommentar = kommentar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public BloqqPost getBloqqPost() {
        return bloqqPost;
    }

    public void setBloqqPost(BloqqPost bloqqPost) {
        this.bloqqPost = bloqqPost;
    }
}
