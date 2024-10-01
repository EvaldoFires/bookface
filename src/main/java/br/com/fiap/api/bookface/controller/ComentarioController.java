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

import br.com.fiap.api.bookface.entities.Comentario;
import br.com.fiap.api.bookface.service.ComentarioService;

@RestController
@RequestMapping("/comentario")
public class ComentarioController implements Controller<Comentario>{

	@Autowired
	private ComentarioService comentarioService;
	
	
	@GetMapping
	public ResponseEntity<List<Comentario>> listar(){
		return ResponseEntity.ok(comentarioService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Comentario> findById(@PathVariable Long id) {
		Comentario comentario = comentarioService.buscar(id);
		return ResponseEntity.ok(comentario);
	}
	
	@PostMapping
	public ResponseEntity<Comentario> create(Comentario comentario) {
		comentario = comentarioService.salvar(comentario);
		return ResponseEntity.status(HttpStatus.CREATED).body(comentario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Comentario> update(@PathVariable Long id, @RequestBody Comentario comentario) {
		Comentario comentarioAtual = comentarioService.update(id, comentario);
		return ResponseEntity.ok(comentarioAtual);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete (@PathVariable Long id) {
		comentarioService.excluir(id);
		return ResponseEntity.noContent().build();
	}

}
