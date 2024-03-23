package com.security.jwt.repositories.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "libros")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String titulo;
    private String autor;
    private String genero;
    private int año;
    private int inventario;

    public boolean existeInventario(){
        return this.inventario > 0;
    }
}
