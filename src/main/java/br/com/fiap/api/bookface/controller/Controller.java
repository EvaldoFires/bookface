package br.com.fiap.api.bookface.controller;

import java.util.List;

public interface Controller<T> {
	public List<T> listar();
	public T buscar(Long id);
	public T salvar(T obj);
	public T atualizar(Long id, T obj);
	public void deletar(Long id);
}

