package br.com.fiap.api.bookface.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.api.bookface.entities.Comentario;
import br.com.fiap.api.bookface.repository.ComentarioRepository;

@Service
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	public Comentario salvar(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}
	
	public Comentario buscar(Long id){
		return comentarioRepository.findById(id)
				.orElseThrow();
	}
	
	public List<Comentario> listar(){
		return comentarioRepository.findAll();
	}
	
	public void excluir(Long id) {
		comentarioRepository.deleteById(id);
	}
}
