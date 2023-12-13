package com.sena.carritocompra.IService;

import java.util.List;
import java.util.Optional;

import com.sena.carritocompra.Entity.ContinenteEntity;
public interface IContinenteService {

	
	
	
	/**
	 * Método para consultar todo
	 * **/
	public List<ContinenteEntity> findAll();
	
	/**
	 * Método para consultar por id
	 * **/
	public Optional<ContinenteEntity> findById(Long id);
	
	
	/**
	 * Método para guardar
	 * **/
	public ContinenteEntity save(ContinenteEntity Continente);
	
	/**
	 * Método para modificar
	 * **/
	public void update(ContinenteEntity Continente, Long id);
	
	/**
	 * Método para eliminar
	 * **/
	public void delete(Long id);
	
	/**
	 * Método para eliminar lógico
	 * **/
	public void deletedAt(Long id);

	
}

