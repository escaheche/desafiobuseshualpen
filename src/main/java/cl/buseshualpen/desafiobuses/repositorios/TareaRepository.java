package cl.buseshualpen.desafiobuses.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.buseshualpen.desafiobuses.modelo.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
	
	List<Tarea> findByProyectoId(Long proyectoId);

}
