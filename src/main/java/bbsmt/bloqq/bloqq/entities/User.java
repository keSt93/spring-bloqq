package bbsmt.bloqq.bloqq.entities;

import bbsmt.bloqq.bloqq.utils.UserUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.sql.Blob;
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
    private Blob picture;

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
        try {
            int bloblength = (int) picture.length();
            byte[] blobByte = picture.getBytes(1, bloblength);

            StringBuilder sb = new StringBuilder();
            sb.append("data:image/jpeg;base64,");
            sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(blobByte, false)));
            return sb.toString();

        } catch (Exception x) {
            return "data:image/jpeg;base64,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";
        }
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
