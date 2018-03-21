package bbsmt.bloqq.bloqq.entities;

import bbsmt.bloqq.bloqq.utils.UserUtils;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String userName;

    @Column
    private String password;

    @Column
    private Date creationDate;

    @OneToMany(mappedBy = "kommentar")
    List<Kommentar> kommentare;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = UserUtils.calcPasswordHash(password);
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Kommentar> getKommentare() {
        return kommentare;
    }

    public void setKommentare(List<Kommentar> kommentare) {
        this.kommentare = kommentare;
    }
}
