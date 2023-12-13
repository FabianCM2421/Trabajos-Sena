package com.sena.carritocompra.Controller;

import com.sena.carritocompra.Entity.PaisEntity;
import com.sena.carritocompra.IService.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/pais")

public class PaisController {

	@Autowired  private IPaisService service;
	@GetMapping
	public List<PaisEntity> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<PaisEntity> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public PaisEntity save(@RequestBody PaisEntity detalleFactura) {
		return service.save(detalleFactura);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody PaisEntity detalleFactura, @PathVariable  Long id) {
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