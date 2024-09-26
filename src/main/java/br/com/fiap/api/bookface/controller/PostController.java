package br.com.fiap.api.bookface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.api.bookface.entities.Post;
import br.com.fiap.api.bookface.service.PostService;

@RestController
public class PostController implements Controller<Post>{

	@Autowired
	private PostService postService;

	@GetMapping
	@Override
	public List<Post> listar() {
		return postService.listar();
	}

	@GetMapping("/{id}")
	@Override
	public Post buscar(@PathVariable Long id) {
		return postService.buscar(id);
	}

	@PostMapping
	@Override
	public Post salvar(@RequestBody Post post) {
		return postService.salvar(post);
	}

	@PutMapping("/{id}")
	@Override
	public Post atualizar(@PathVariable Long id,@RequestBody Post post) {
		Post postAtual = this.buscar(id);
		return this.salvar(postAtual);
	}

	@DeleteMapping("/{id}")
	@Override
	public void deletar(Long id) {
		postService.excluir(id);
	}

	
}
