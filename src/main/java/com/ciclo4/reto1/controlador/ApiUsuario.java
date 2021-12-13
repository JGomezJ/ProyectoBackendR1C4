/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto1.controlador;

import com.ciclo4.reto1.entidad.Usuario;
import com.ciclo4.reto1.servicio.UsuarioServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins="*", methods={RequestMethod.GET, RequestMethod.POST})
public class ApiUsuario {
    @Autowired
    UsuarioServicio userService;
    
    @GetMapping("/all")
    public List<Usuario> getUsuarios(){
        return userService.getUsuarios();
    }
    
    @GetMapping("/{email}")
    public String getEmail(@PathVariable("email") String email){
        return userService.getUserEmail(email);
    }
    
    @GetMapping("/{email}/{password}")
    public Usuario getUserEmailPassword(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.getUserEmailPassword(email, password);
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario saveUser(@RequestBody Usuario user){
        return userService.saveUsuario(user);
    }
}
