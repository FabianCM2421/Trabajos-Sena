package com.sena.carritocompra.Controller;

import com.sena.carritocompra.Entity.ContinenteEntity;
import com.sena.carritocompra.IService.IContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/Continente")

public class ContinenteController {

	@Autowired  private IContinenteService service;
	@GetMapping
	public List<ContinenteEntity> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<ContinenteEntity> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public ContinenteEntity save(@RequestBody ContinenteEntity detalleFactura) {
		return service.save(detalleFactura);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody ContinenteEntity detalleFactura, @PathVariable  Long id) {
		service.update(detalleFactura, id);
	}
	
	@PutMapping("deleted-at/{id}")
	public void deletedAt(@PathVariable  Long id) {
		service.deletedAt(id);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable  Long id) {
		service.delete(id);
	}
}