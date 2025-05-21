package cl.buseshualpen.desafiobuses.controladores;


import cl.buseshualpen.desafiobuses.dto.ProyectoDTO;
import cl.buseshualpen.desafiobuses.dto.TareaDTO;
import cl.buseshualpen.desafiobuses.servicios.ProyectoService;
import cl.buseshualpen.desafiobuses.servicios.TareaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private TareaService tareaService;

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping
    public ResponseEntity<ProyectoDTO> crearProyecto(@Valid @RequestBody ProyectoDTO dto) {
        return ResponseEntity.ok(proyectoService.crearProyecto(dto));
    }
    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('USUARIO')")
    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> listarProyectos() {
        return ResponseEntity.ok(proyectoService.listarProyectos());
    }
    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('USUARIO')")
    @GetMapping("/{id}/tareas")
    public ResponseEntity<List<TareaDTO>> listarTareasPorProyecto(@PathVariable Long id) {
        return ResponseEntity.ok(tareaService.listarTareasPorProyecto(id));
    }
}
