package com.example.demo.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long iduser;
    private String username;
    private  String  password;
    private Boolean active;

    private String mail;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "User_role", joinColumns = { @JoinColumn(name = "username", referencedColumnName = "username") },
            inverseJoinColumns = {@JoinColumn(name = "Role", referencedColumnName = "role")})
    private List<Roles> roles;

    public Users(String username,  String password, String mail,Boolean active) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.active=active;

    }

    public Users() {
        super();
    }

    public Long getIduser() {
        return iduser;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
