package com.example.demo.User;

import com.example.demo.OrderHdr.OrderHdr;

import java.util.List;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @SequenceGenerator(
            name = "userSequence",
            sequenceName = "userSequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "userSequence"
    )


    private Long userId;
    private String userName;
    private String fullName;
    private String password;
    private int type;
    @OneToMany
    @JoinColumn(name = "userId")
    private List<OrderHdr> orders;

    // standard constructors
    public User() {
    }

    public List<OrderHdr> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderHdr> orders) {
        this.orders = orders;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User(Long userId, String userName, String fullName, String password) {
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
    }

    public User(String userName, String fullName, String password) {
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
    }


    // standard getters and setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long value) {
        this.userId = value;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String value) {
        this.userName = value;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String value) {
        this.fullName = value;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String value) {
        this.password = value;
    }
}

