package br.com.fiap.api.bookface.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {

	private Long id;
	private String titulo;
	private String conteudo;
	private String tags;
	private UsuarioDTO usuario;
	private List<String> listaCurtidas;
	private List<ComentarioDTO> comentarios;
}
