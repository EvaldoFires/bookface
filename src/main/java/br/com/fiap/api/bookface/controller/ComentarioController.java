package br.com.fiap.api.bookface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.api.bookface.entities.Comentario;
import br.com.fiap.api.bookface.service.ComentarioService;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {

	@Autowired
	private ComentarioService comentarioService;
	
	@GetMapping
	private List<Comentario> listar(){
		return comentarioService.listar();
	}
	
	@GetMapping("/{id}")
	private Comentario buscar(@PathVariable Long id) {
		return comentarioService.buscar(id);
	}
	
	@PutMapping("/{id}")
	private Comentario atualizar(@PathVariable Long id, @RequestBody Comentario comentario) {
		Comentario comentarioAtual;
		comentarioAtual = this.buscar(id);
		
		return comentarioService.salvar(comentario);
	}
}
