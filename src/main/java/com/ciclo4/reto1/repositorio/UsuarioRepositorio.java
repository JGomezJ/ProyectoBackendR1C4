/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto1.repositorio;

import com.ciclo4.reto1.entidad.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
@Component
public interface UsuarioRepositorio extends CrudRepository<Usuario,Integer>{
    @Query(value="Select * from user where usuario_Email = ?1", nativeQuery=true)
    public Usuario findByUserEmail(String user_Email);
    
    @Query(value="Select * from user where usuario_Email = ?1 and usuario_Clave = ?2", nativeQuery=true)
    public Usuario findByUserEmailPassaword(String user_Email, String user_Password);
}
