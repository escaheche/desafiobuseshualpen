package cl.buseshualpen.desafiobuses.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.buseshualpen.desafiobuses.dto.ProyectoDTO;
import cl.buseshualpen.desafiobuses.mapper.ProyectoMapper;
import cl.buseshualpen.desafiobuses.modelo.Proyecto;
import cl.buseshualpen.desafiobuses.repositorios.ProyectoRepository;

import java.util.List;

@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private ProyectoMapper proyectoMapper;

    public ProyectoDTO crearProyecto(ProyectoDTO dto) {
        Proyecto proyecto = proyectoMapper.toEntity(dto);
        System.out.println("DEBUG -> Nombre recibido en DTO: " + dto.getNombre());
        System.out.println("DEBUG -> Nombre convertido en entidad: " + proyecto.getNombre());
        return proyectoMapper.toDTO(proyectoRepository.save(proyecto));
    }


    public List<ProyectoDTO> listarProyectos() {
        return proyectoMapper.toDTOs(proyectoRepository.findAll());
    }
}
