/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto1.servicio;

import com.ciclo4.reto1.entidad.Usuario;
import com.ciclo4.reto1.repositorio.UsuarioRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio userRepo;
    
    public List<Usuario> getUsuarios(){
        return (List<Usuario>) userRepo.findAll();
    }
        
    public Usuario saveUsuario(Usuario user){
        return userRepo.save(user);
    }
    
    private Boolean validUserEmail(String email){
        Usuario u = userRepo.findByUserEmail(email);
        try {
            u.getEmail();
            return true;
        } catch (NullPointerException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getUserEmail(String email){
        return validUserEmail(email) ? "true" : "false";
    }
    
    public Usuario getUserEmailPassword(String email, String Password){
        Usuario u1 = userRepo.findByUserEmailPassaword(email, Password);
        try {
            u1.getId();
            return u1;
        } catch (NullPointerException e) {
            Usuario u2 = new Usuario();
            u2.setId(null);
            u2.setEmail(email);
            u2.setPassword(Password);
            u2.setName("NO DEFINIDO");
            return u2;
        } 
    }
}
