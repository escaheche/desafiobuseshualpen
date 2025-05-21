package cl.buseshualpen.desafiobuses.servicios;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import cl.buseshualpen.desafiobuses.modelo.Usuario;
import cl.buseshualpen.desafiobuses.repositorios.UsuarioRepository;


@Service 
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
    private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Usuario usuario = usuarioRepository.findByUsername(username)
	        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
	    System.out.println("Username: " + usuario.getUsername() + " | Password hash: " + usuario.getPassword());
	    return new User(
	        usuario.getUsername(),
	        usuario.getPassword(),
	        List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString())) // .name() por seguridad, aunque .toString() también suele funcionar
	    );
	}
}
