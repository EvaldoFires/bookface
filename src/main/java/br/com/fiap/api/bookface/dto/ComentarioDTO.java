package br.com.fiap.api.bookface.dto;

import org.modelmapper.ModelMapper;

import br.com.fiap.api.bookface.entities.Comentario;
import br.com.fiap.api.bookface.entities.Post;
import br.com.fiap.api.bookface.entities.Usuario;

public class ComentarioDTO {

	private Long id;
	private Usuario usuario;
	private String texto;
	private Post post;
	
	public ComentarioDTO() {}

	public ComentarioDTO(Usuario usuario, String comentario, Post post) {
		super();
		this.usuario = usuario;
		this.texto = comentario;
		this.post = post;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public ComentarioDTO toDTO(Comentario comentario) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(comentario, ComentarioDTO.class);
	}
	
	public Comentario toDomainObj(ComentarioDTO comentarioDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(comentarioDTO, Comentario.class);
	}
}
