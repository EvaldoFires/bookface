package br.com.fiap.api.bookface.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String texto;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private final Usuario usuario;
	@ManyToOne
	@JoinColumn(nullable = false)
	private Post post;
	
	public Comentario(Usuario usuario, String comentario) {
		super();
		this.usuario = usuario;
		this.texto = comentario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String comentario) {
		this.texto = comentario;
	}

	public Long getId() {
		return id;
	}
	
	public Post getPost() {
		return this.post;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", usuario=" + usuario + ", comentario=" + texto + "]";
	}
	
	
}
