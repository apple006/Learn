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
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String website;
    private Double balance = 0.0;
    private Date createTime = new Date();
    private Boolean isAlive = true;

    protected User() {

    }

    public User(String name, String email, String website) {
        this.name = name;
        this.email = email;
        this.website = website;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }
}
