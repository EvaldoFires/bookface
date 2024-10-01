package br.com.fiap.api.bookface.dto;

import java.util.List;

import org.modelmapper.ModelMapper;

import br.com.fiap.api.bookface.entities.Post;

public class PostDTO {

	private Long id;
	private String titulo;
	private String conteudo;
	private String tags;
	private UsuarioDTO usuario;
	private List<String> listaCurtidas;
	private List<ComentarioDTO> comentarios;
	
	public PostDTO() {}

	public PostDTO(String titulo, String conteudo, String tags, UsuarioDTO usuario, List<String> listaCurtidas,
			List<ComentarioDTO> comentarios) {
		super();
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.tags = tags;
		this.usuario = usuario;
		this.listaCurtidas = listaCurtidas;
		this.comentarios = comentarios;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public List<String> getListaCurtidas() {
		return listaCurtidas;
	}

	public void setListaCurtidas(List<String> listaCurtidas) {
		this.listaCurtidas = listaCurtidas;
	}

	public List<ComentarioDTO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentarioDTO> comentarios) {
		this.comentarios = comentarios;
	}
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public PostDTO toDTO(Post post) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(post, PostDTO.class);
	}
	
	public Post toDomainObj(PostDTO postDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(postDTO, Post.class);
	}
	
}
