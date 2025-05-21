package cl.buseshualpen.desafiobuses.controladores;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import cl.buseshualpen.desafiobuses.dto.TareaDTO;
import cl.buseshualpen.desafiobuses.servicios.TareaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping
    public ResponseEntity<TareaDTO> crearTarea(@Valid @RequestBody TareaDTO dto) {
        return ResponseEntity.ok(tareaService.crearTarea(dto));
    }
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping("/{id}/completar")
    public ResponseEntity<TareaDTO> completar(@PathVariable Long id) {
        return ResponseEntity.ok(tareaService.marcarTareaComoCompletada(id));
    }
}
