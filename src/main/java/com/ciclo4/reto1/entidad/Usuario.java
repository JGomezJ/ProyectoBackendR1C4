/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ciclo4.reto1.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Usuario
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idUsuario", length=11, nullable=true)
    private Integer id;
    @Column(name="usuario_Email", length=50, nullable=false, unique=true)
    private String email;
    @Column(name="usuario_Nombre", length=80, nullable=false)
    private String name;
    @Column(name="usuario_Clave", length=50, nullable=false)
    private String password;
}
