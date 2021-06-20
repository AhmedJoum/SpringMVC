package com.example.demo.User;


import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )


    private Long user_id;
    private String user_name;
    private String full_name;
    private String password;
    private int Type;

    // standard constructors
    public User() {
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        this.Type = type;
    }

    public User(Long user_id, String user_name, String full_name, String password) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.full_name = full_name;
        this.password = password;
    }

    public User(String user_name, String full_name, String password) {
        this.user_name = user_name;
        this.full_name = full_name;
        this.password = password;
    }


    // standard getters and setters

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

