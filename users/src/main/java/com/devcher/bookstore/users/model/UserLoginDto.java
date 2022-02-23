package com.devcher.bookstore.users.model;
import javax.persistence.*;

@Entity
public class UserLoginDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    public UserLoginDto(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public UserLoginDto() {

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
