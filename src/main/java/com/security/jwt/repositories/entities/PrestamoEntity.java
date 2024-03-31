package com.security.jwt.repositories.entities;

import java.util.Date;

import com.security.jwt.resources.enums.EstadoPrestamo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "prestamos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrestamoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libros_id")
    private LibroEntity libro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private UserEntity usuario;
    
    @Column(nullable = false)
    private Date prestamo;
    @Column(nullable = false)
    private Date devolucion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPrestamo estado;

    // Auto devolution date function
    // public Date fechaDevolucion(){
    //     LocalDate newDate = prestamo.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    //     newDate = newDate.plusMonths(1);
    //     return Date.from(newDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    // }
}
