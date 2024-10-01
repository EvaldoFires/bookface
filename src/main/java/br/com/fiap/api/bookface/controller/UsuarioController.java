package br.com.fiap.api.bookface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.api.bookface.entities.Usuario;
import br.com.fiap.api.bookface.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements Controller<Usuario>{
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	@Override
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.ok(usuarioService.listar());
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<Usuario> findById(@PathVariable Long id) {
		Usuario usuario = usuarioService.buscar(id);
		return ResponseEntity.ok(usuario);
	}

	@PostMapping
	@Override
	public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
		usuario = usuarioService.salvar(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
		Usuario usuarioAtual = usuarioService.update(id, usuario);
		return ResponseEntity.ok(usuarioAtual);
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		usuarioService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	

}
