package br.com.fiap.api.bookface.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.api.bookface.entities.Usuario;
import br.com.fiap.api.bookface.exceptions.ControllerNotFoundException;
import br.com.fiap.api.bookface.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Usuario buscar(Long id) {
		return usuarioRepository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Usuario não encontrado"));
	}
	
	public List<Usuario> listar(){
		return usuarioRepository.findAll();
	}
	
	public void excluir(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario usuario) {
		Usuario usuarioAtual = this.buscar(id);
		usuarioAtual.setNome(usuario.getNome());
		usuarioAtual.setEmail(usuario.getEmail());
		usuarioAtual.setSenha(usuario.getSenha());
		return usuarioRepository.save(usuarioAtual);
	}
}
