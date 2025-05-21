package cl.buseshualpen.desafiobuses.mapper;



import java.util.List;
import org.mapstruct.Mapper;
import cl.buseshualpen.desafiobuses.dto.ProyectoDTO;
import cl.buseshualpen.desafiobuses.modelo.Proyecto;



//Mapper de Proyecto a ProyectoDTO y viceversa
@Mapper(componentModel = "spring")
public interface ProyectoMapper {
    ProyectoDTO toDTO(Proyecto proyecto);
    Proyecto toEntity(ProyectoDTO dto);
    List<ProyectoDTO> toDTOs(List<Proyecto> proyectos);
}
