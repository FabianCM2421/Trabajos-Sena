package com.sena.carritocompra.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.carritocompra.Entity.PaisEntity;
import com.sena.carritocompra.IRepository.IPaisRepository;
import com.sena.carritocompra.IService.IPaisService;

@Service
public class PaisService implements IPaisService{

	@Autowired
	private IPaisRepository repository;
	
	@Override
	public List<PaisEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<PaisEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public PaisEntity save(PaisEntity Pais) {
		Pais.setFechaCreacion(LocalDateTime.now());
		return repository.save(Pais);
	}

	@Override
	public void update(PaisEntity Pais, Long id) {
		//Consultar si existe el registro
				Optional<PaisEntity> op = repository.findById(id);
				
				if(op.isEmpty()){
					System.out.print("Registro no existe.");
				}else {
					PaisEntity updatePais = op.get();					
					updatePais.setNombre(Pais.getNombre());
					updatePais.setCodigo(Pais.getCodigo());
					updatePais.setEstado(Pais.getEstado());
					updatePais.setContinenteId(Pais.getContinenteId());
					updatePais.setFechaModificacion(LocalDateTime.now());
					
					repository.save(updatePais);
				}
	}
	
	@Override
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<PaisEntity> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			PaisEntity updatepais = op.get();					
			updatepais.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updatepais);
		}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}



}
