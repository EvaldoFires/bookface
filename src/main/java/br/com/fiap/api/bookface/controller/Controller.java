package br.com.fiap.api.bookface.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface Controller<T> {
	public ResponseEntity<List<T>> listar();
	public ResponseEntity<T> findById(Long id);
	public ResponseEntity<T> create(T obj);
	public ResponseEntity<T> update(Long id, T obj);
	public ResponseEntity<Void> delete(Long id);
}

