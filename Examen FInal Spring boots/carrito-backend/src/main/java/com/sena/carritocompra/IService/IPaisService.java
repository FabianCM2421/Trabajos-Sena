package com.sena.carritocompra.IService;

import java.util.List;
import java.util.Optional;

import com.sena.carritocompra.Entity.PaisEntity;
public interface IPaisService {

	
	
	
	/**
	 * Método para consultar todo
	 * **/
	public List<PaisEntity> findAll();
	
	/**
	 * Método para consultar por id
	 * **/
	public Optional<PaisEntity> findById(Long id);
	
	
	/**
	 * Método para guardar
	 * **/
	public PaisEntity save(PaisEntity Pais);
	
	/**
	 * Método para modificar
	 * **/
	public void update(PaisEntity Pais, Long id);
	
	/**
	 * Método para eliminar
	 * **/
	public void delete(Long id);
	
	/**
	 * Método para eliminar lógico
	 * **/
	public void deletedAt(Long id);
	
}