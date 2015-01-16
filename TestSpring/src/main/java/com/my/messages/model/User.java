package com.my.messages.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="users")
public class    User {


    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Integer id;

    @NotEmpty  (message = "Поле не должны быть пустыми!!!")
    @Column(name="firstname")
    private String firstName;

    @NotEmpty  (message = "Поле не должны быть пустыми!!!")
    @Column(name="lastname")
    private String lastName;


    @NotEmpty (message = "Поле не должны быть пустыми!!!")
    @Column(name="username",unique=true)
    private String userName;

    @NotEmpty (message = "Поле не должны быть пустыми!!!")
    @Column(name="password")
    private String password;


    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",
            joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
            inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")} )
    private List<Role> roles = new ArrayList<Role>();

    @OneToMany(mappedBy = "receiver")
    private List<Message> messages = new ArrayList<Message>();



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
