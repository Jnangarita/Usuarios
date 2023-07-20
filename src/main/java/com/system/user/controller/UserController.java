package com.system.user.controller;

import com.system.user.models.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * la anotación @RestController le dice a spring-boot que esta clase va a ser un controlador,
 * y un controlador es una clase que se encarga de manejar las url de una página web
 */
@RestController
public class UserController {
    /**
     * @RequestMapping se usa para establecer la URL o una ruta de solicitud a un método
     * especifico en un controlador
     * @return una cadena de prueba para comprobar que el método esta funcionando correctamente
     */

    // método de prueba
    @RequestMapping(value = "prueba")
    public String test(){
        return "Probando el método test del UserController";
    }

    // este método devuelve solo un usuario de tipo User
    @RequestMapping(value = "api/usuario")
    public User getUserTest(){
        // id, name, lastName, email, phone, password
        User user = new User(15, "John", "Angarita", "john@gmail.com", "11", "12345");
        return user;
    }

    /**
     * @PathVariable se utiliza para capturar valores de variables de ruta de una URL y
     * la utiliza como argumento en un método del controlador (getUser(@PathVariable int id))
     * @param id
     * @return
     */

    // el método recibe un argumento id y se lo pasa al constructor de User, de esta manera
    // hace que el id sea dinamico y no estatico
    @RequestMapping(value = "api/usuario/{id}")
    public User getUser(@PathVariable int id){
        // id, name, lastName, email, phone, password
        User user = new User(id, "John", "Angarita", "john@gmail.com", "11", "12345");
        return user;
    }

    @RequestMapping(value = "api/usuarios")
    public List<User> getUser(){
        List<User> userList = new ArrayList<>();
        User user = new User(1, "John", "Angarita", "john@gmail.com", "11", "12345");
        User user1 = new User(2, "Kevin", "Jose", "jose@gmail.com", "22", "54321");
        User user2 = new User(3, "Yorle", "Lauren", "lauren@gmail.com", "33", "098765");

        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        return userList;
    }
}