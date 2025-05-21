package cl.buseshualpen.desafiobuses.modelo;

//Entidad que representa una tarea asociada a un proyecto
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

// Tarea: pertenece a un proyecto, tiene fecha límite y puede estar completada
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarea {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String titulo;

	    @Column(nullable = false)
	    private LocalDate fechaLimite;

	    @Builder.Default
	    @Column(nullable = false)
	    private boolean completada = false;

	    @ManyToOne
	    @JoinColumn(name = "proyecto_id", nullable = false)
	    private Proyecto proyecto;
}
