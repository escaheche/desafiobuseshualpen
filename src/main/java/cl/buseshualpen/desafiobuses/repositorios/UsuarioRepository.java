package cl.buseshualpen.desafiobuses.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.buseshualpen.desafiobuses.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Optional<Usuario> findByUsername(String username);
	boolean existsByUsername(String username);
}
