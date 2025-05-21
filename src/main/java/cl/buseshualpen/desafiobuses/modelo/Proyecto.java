package cl.buseshualpen.desafiobuses.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

// Proyecto: cada uno tiene un nombre y muchas tareas asociadas
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    // Un proyecto puede tener muchas tareas
    @OneToMany(mappedBy = "proyecto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarea> tareas;
    
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}