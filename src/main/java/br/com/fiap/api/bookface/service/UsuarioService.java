package br.com.fiap.api.bookface.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.api.bookface.entities.Usuario;
import br.com.fiap.api.bookface.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscar(Long id) {
		return usuarioRepository.findById(id).orElseThrow();
	}
	
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	public void excluir(Long id) {
		usuarioRepository.deleteById(id);
	}
}
