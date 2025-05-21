package cl.buseshualpen.desafiobuses.mapper;

import org.mapstruct.*;
import cl.buseshualpen.desafiobuses.dto.TareaDTO;
import cl.buseshualpen.desafiobuses.modelo.Tarea;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TareaMapper {

	// Usamos default para manejar el id del proyecto y la fecha
	default TareaDTO toDTO(Tarea tarea) {
		if (tarea == null)
			return null;
		TareaDTO dto = new TareaDTO();
		dto.setId(tarea.getId());
		dto.setTitulo(tarea.getTitulo());
		dto.setCompletada(tarea.isCompletada());
		dto.setProyectoId(tarea.getProyecto() != null ? tarea.getProyecto().getId() : null);
		dto.setFechaLimite(
				tarea.getFechaLimite() != null ? tarea.getFechaLimite().format(DateTimeFormatter.ofPattern("yyyyMMdd"))
						: null);
		return dto;
	}

	List<TareaDTO> toDTOs(List<Tarea> tareas);

	// Para convertir de DTO a entidad (proyecto se setea en el servicio)
	default Tarea toEntity(TareaDTO dto) {
		if (dto == null)
			return null;
		Tarea tarea = new Tarea();
		tarea.setId(dto.getId());
		tarea.setTitulo(dto.getTitulo());
		tarea.setCompletada(dto.isCompletada());
		tarea.setFechaLimite(dto.getFechaLimite() != null
				? LocalDate.parse(dto.getFechaLimite(), DateTimeFormatter.ofPattern("yyyyMMdd"))
				: null);
		// tarea.setProyecto(null); // el servicio lo setea
		return tarea;
	}
}