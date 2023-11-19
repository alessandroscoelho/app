package com.spring.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.app.domain.Usuario;
import com.spring.app.exception.ObjectNotFoundExcepetion;
import com.spring.app.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario findById(Integer id) {
		Optional<Usuario> obj = usuarioRepository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundExcepetion("Objeto não encontrado! Id: "+id+", Tipo: "+ Usuario.class.getName()));
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}
