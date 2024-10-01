package br.com.fiap.api.bookface.dto;

import org.modelmapper.ModelMapper;

import br.com.fiap.api.bookface.entities.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;

	public UsuarioDTO() {}

	public UsuarioDTO(String nome, String email) {
		super();
		this.nome = nome;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 
	public UsuarioDTO toDTO(Usuario usuario) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(usuario, UsuarioDTO.class);
	}
	
	public Usuario toDomainObj(UsuarioDTO usuarioDTO) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(usuarioDTO, Usuario.class);
	}
}
