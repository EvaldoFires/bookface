package br.com.fiap.api.bookface.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.api.bookface.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
