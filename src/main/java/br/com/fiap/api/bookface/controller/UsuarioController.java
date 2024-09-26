package br.com.fiap.api.bookface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fiap.api.bookface.entities.Usuario;
import br.com.fiap.api.bookface.service.UsuarioService;

public class UsuarioController implements Controller<Usuario>{
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	@Override
	public List<Usuario> listar() {
		return usuarioService.listar();
	}

	@GetMapping("/{id}")
	@Override
	public Usuario buscar(@PathVariable Long id) {
		return usuarioService.buscar(id);
	}

	@PostMapping
	@Override
	public Usuario salvar(@RequestBody Usuario usuario) {
		return usuarioService.salvar(usuario);
	}

	@PutMapping("/{id}")
	@Override
	public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioAtual = this.buscar(id);
		return usuarioService.salvar(usuarioAtual);
	}

	@DeleteMapping("/{id}")
	@Override
	public void deletar(@PathVariable Long id) {
		usuarioService.excluir(id);
	}
	
	

}
