package cl.buseshualpen.desafiobuses.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.buseshualpen.desafiobuses.dto.TareaDTO;
import cl.buseshualpen.desafiobuses.mapper.TareaMapper;
import cl.buseshualpen.desafiobuses.modelo.Proyecto;
import cl.buseshualpen.desafiobuses.modelo.Tarea;
import cl.buseshualpen.desafiobuses.repositorios.ProyectoRepository;
import cl.buseshualpen.desafiobuses.repositorios.TareaRepository;



@Service
public class TareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private TareaMapper tareaMapper;

    public TareaDTO crearTarea(TareaDTO dto) {
        Tarea tarea = tareaMapper.toEntity(dto);
        Proyecto proyecto = proyectoRepository.findById(dto.getProyectoId())
                .orElseThrow(() -> new RuntimeException("Proyecto no encontrado"));
        tarea.setProyecto(proyecto);
        tarea.setCompletada(false); // Si quieres setear el valor por defecto
        return tareaMapper.toDTO(tareaRepository.save(tarea));
    }

    public List<TareaDTO> listarTareasPorProyecto(Long proyectoId) {
        return tareaMapper.toDTOs(tareaRepository.findByProyectoId(proyectoId));
    }

    public TareaDTO marcarTareaComoCompletada(Long tareaId) {
        Tarea tarea = tareaRepository.findById(tareaId)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        tarea.setCompletada(true);
        return tareaMapper.toDTO(tareaRepository.save(tarea));
    }
}