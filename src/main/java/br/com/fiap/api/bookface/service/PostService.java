package br.com.fiap.api.bookface.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.api.bookface.entities.Post;
import br.com.fiap.api.bookface.repository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post salvar(Post post) {
		return postRepository.save(post);
	}
	
	public Post buscar(Long id){
		return postRepository.findById(id).orElseThrow();
	}
	
	public List<Post> listar(){
		return postRepository.findAll();
	}
	
	public void excluir(Long id) {
		postRepository.deleteById(id);
	}
	
}
