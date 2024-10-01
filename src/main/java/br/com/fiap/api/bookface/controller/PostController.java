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

import br.com.fiap.api.bookface.entities.Post;
import br.com.fiap.api.bookface.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController implements Controller<Post>{

	@Autowired
	private PostService postService;

	@GetMapping
	@Override
	public ResponseEntity<List<Post>> listar() {
		return ResponseEntity.ok(postService.listar());
	}

	@GetMapping("/{id}")
	@Override
	public ResponseEntity<Post> findById(@PathVariable Long id) {
		Post post = postService.buscar(id);
		return ResponseEntity.ok(post);
	}

	@PostMapping
	@Override
	public ResponseEntity<Post> create(@RequestBody Post post) {
		post = postService.salvar(post);
		return ResponseEntity.status(HttpStatus.CREATED).body(post);
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<Post> update(@PathVariable Long id,@RequestBody Post post) {
		Post postAtual = postService.update(id, post);
		return this.create(postAtual);
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> delete(Long id) {
		postService.excluir(id);
		return ResponseEntity.noContent().build();
	}

	
}
