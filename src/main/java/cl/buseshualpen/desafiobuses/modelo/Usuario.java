package cl.buseshualpen.desafiobuses.modelo;

import jakarta.persistence.*;
import lombok.*;

// Usuario: para autenticación y autorización
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password; // Se almacena encriptada

    @Enumerated(EnumType.STRING)
    private Rol rol;

   
}

