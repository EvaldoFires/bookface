package br.com.fiap.api.bookface.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.api.bookface.entities.Post;
import br.com.fiap.api.bookface.exceptions.ControllerNotFoundException;
import br.com.fiap.api.bookface.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post salvar(Post post) {
		return postRepository.save(post);
	}
	
	public Post buscar(Long id){
		return postRepository.findById(id)
				.orElseThrow(() -> new ControllerNotFoundException("Post não encontrado"));
	}
	
	public List<Post> listar(){
		return postRepository.findAll();
	}
	
	public void excluir(Long id) {
		postRepository.deleteById(id);
	}
	
	public Post update(Long id, Post post) {
		Post postAtual = this.buscar(id);
		postAtual.setConteudo(post.getConteudo());
		postAtual.setTags(post.getTags());
		postAtual.setTitulo(post.getTitulo());
		return postRepository.save(postAtual);
	}
	
}
