package com.system.user.controller;

import com.system.user.dao.UserDao;
import com.system.user.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    // @Autowired automaticamente crea el objeto userDao (si se usa esta anotación en otras clases los objetos
    // van a compartir memoria, así que hay que usarlo con precaución)
    @Autowired
    private UserDao userDao;

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
    @RequestMapping(value = "api/usuario/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id){
        // id, name, lastName, email, phone, password
        User user = new User(id, "John", "Angarita", "john@gmail.com", "11", "12345");
        return user;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<User> getUser(){
        return userDao.getUser();
    }

    @RequestMapping(value = "api/usuarios/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        userDao.delete(id);
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){
        userDao.register(user);
    }
}