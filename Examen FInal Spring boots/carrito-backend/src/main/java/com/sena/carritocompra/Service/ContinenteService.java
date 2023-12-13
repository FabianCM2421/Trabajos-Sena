package com.sena.carritocompra.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.carritocompra.Entity.ContinenteEntity;
import com.sena.carritocompra.IRepository.IContinenteRepository;
import com.sena.carritocompra.IService.IContinenteService;

@Service
public class ContinenteService implements IContinenteService{

	@Autowired
	private IContinenteRepository repository;
	
	@Override
	public List<ContinenteEntity> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<ContinenteEntity> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public ContinenteEntity save(ContinenteEntity Continente) {
		Continente.setFechaCreacion(LocalDateTime.now());
		return repository.save(Continente);
	}

	@Override
	public void update(ContinenteEntity Continente, Long id) {
		//Consultar si existe el registro
				Optional<ContinenteEntity> op = repository.findById(id);
				
				if(op.isEmpty()){
					System.out.print("Registro no existe.");
				}else {
					ContinenteEntity updateContinente = op.get();					
					updateContinente.setNombre(Continente.getNombre());
					updateContinente.setCodigo(Continente.getCodigo());
					updateContinente.setEstado(Continente.getEstado());
					updateContinente.setFechaModificacion(LocalDateTime.now());
					
					repository.save(updateContinente);
				}
	}
	
	@Override
	public void deletedAt(Long id) {
		//Consultar si existe el registro
		Optional<ContinenteEntity> op = repository.findById(id);
		
		if(op.isEmpty()){
			System.out.print("Registro no existe para eliminar.");
		}else {
			ContinenteEntity updateCliente = op.get();					
			updateCliente.setFechaEliminacion(LocalDateTime.now());					
			repository.save(updateCliente);
		}	
		
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);	
	}



}
