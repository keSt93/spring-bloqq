package bbsmt.bloqq.bloqq.entities;

import bbsmt.bloqq.bloqq.Utils.UserUtils;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String userName;

    @Column
    private String password;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //@Column(name = "userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //@Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = UserUtils.calcPasswordHash(password);
    }
}
