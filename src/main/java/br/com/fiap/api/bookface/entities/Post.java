package br.com.fiap.api.bookface.entities;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String conteudo;
	
	private String tags;
	
	@ManyToOne
	@JoinColumn(name = "usuario_post_id", nullable = false)
	private Usuario usuario;
	
	private List<String> listaCurtidas;
	
	@OneToMany
	@JoinColumn()
	private List<Comentario> comentarios;
	
	public Post(Usuario usuario, String titulo, String conteudo, String tags) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.tags = tags;
	}
	public void comentar (Comentario comentario) {
		comentarios.add(comentario);
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void curtir(String nomeUsuario ) {
		listaCurtidas.add(nomeUsuario);
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

	public List<String> getListaCurtidas() {
		return listaCurtidas;
	}

	public Long getId() {
		return id;
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
		Post other = (Post) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", titulo=" + titulo + ", conteudo=" + conteudo + ", tags=" + tags + "]";
	}
	
	
}
