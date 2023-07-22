package com.system.user.models;

import javax.persistence.*;

/**
 * En esta clase se van a definir todos los campos que puede tener un usuario
 */
@Entity // para que sepa que hace referencia a la base de datos
@Table(name = "users")// le dice al método getUser de UserDaoImp.java en cual tabla va a ejecutar la consulta
public class User {
    @Id // de esta manera se indica que va a ser la PK
    @Column(name = "id") // nombre de las columnas de la tabla
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "password")
    private String password;

    public User(){}

    public User(int id, String name, String lastName, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}