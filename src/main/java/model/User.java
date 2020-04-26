package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_db")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "money")
    private Long money;

    public User() {

    }

    public User(String name, String password, Long money) {
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public User(long id, String name, String password, Long money) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.money = money;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getMoney(), that.getMoney());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getMoney());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
