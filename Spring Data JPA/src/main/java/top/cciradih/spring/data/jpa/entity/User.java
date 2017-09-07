package top.cciradih.spring.data.jpa.entity;

import javax.persistence.*;
import java.util.Date;

// JPA 使用 @Entity，NoSQL 使用 @Document
@Entity
public class User {
    // 主键
    @Id
    // 由程序控制主键生成策略
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // 约束、不可为空、长度16
    @Column(unique = true, nullable = false, length = 16)
    private String username;
    @Column(unique = true, nullable = false)
    private String email;
    private Double balance = 0.0;
    @Column(updatable = false)
    private Date createTime = new Date();

    public User() {
    }

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                ", createTime=" + createTime +
                '}';
    }
}
