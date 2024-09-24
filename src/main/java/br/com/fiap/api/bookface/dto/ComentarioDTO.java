package br.com.fiap.api.bookface.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioDTO {

	private Long id;
	private UsuarioDTO usuario;
	private String comentario;
	
	
	
}
