package bbsmt.bloqq.bloqq.entities;

import bbsmt.bloqq.bloqq.utils.UserUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @Column
    private byte[] picture;

    @Column
    private Boolean enabled;

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
        this.password = password;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getPicture() {
        return Base64.encodeBase64URLSafeString(picture);
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
