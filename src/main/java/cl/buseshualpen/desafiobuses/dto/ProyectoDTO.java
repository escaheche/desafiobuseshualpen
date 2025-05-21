package cl.buseshualpen.desafiobuses.dto;

import io.swagger.v3.oas.annotations.media.Schema;

//DTO para crear/mostrar un proyecto

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO {

	@Schema(hidden = true)
	private Long id;

	@NotBlank(message = "El nombre del proyecto es obligatorio")
	private String nombre;
	
	
	
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
