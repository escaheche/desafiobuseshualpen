package cl.buseshualpen.desafiobuses.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class TareaDTO {
	@Schema(hidden = true)
    private Long id;
	
    private String titulo;
    private String fechaLimite; // YYYYMMDD
    
    @Schema(hidden = true)
    private boolean completada;
    
    private Long proyectoId;
}