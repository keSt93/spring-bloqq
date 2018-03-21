package bbsmt.bloqq.bloqq.entities;

import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "bloqq_post")
public class BloqqPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String titel;

    @Column
    private Date createDate;

    @Column
    private Date updated;

    @Column
    private String content;

    @OneToMany(mappedBy = "kommentar")
    private List<Kommentar> kommentare;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Kommentar> getKommentare() {
        return kommentare;
    }

    public void setKommentare(List<Kommentar> kommentare) {
        this.kommentare = kommentare;
    }
}
