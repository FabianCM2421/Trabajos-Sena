package com.sena.carritocompra.Controller;

import com.sena.carritocompra.Entity.DepartamentoEntity;
import com.sena.carritocompra.IService.IDepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/Departamento")

public class DepartamentoController {

	@Autowired  private IDepartamentoService service;
	@GetMapping
	public List<DepartamentoEntity> findAll() {
		return service.findAll();
	}
	
	@GetMapping("{id}")
	public Optional<DepartamentoEntity> findById(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@PostMapping
	public DepartamentoEntity save(@RequestBody DepartamentoEntity detalleFactura) {
		return service.save(detalleFactura);
	}
	
	@PutMapping("{id}")
	public void save(@RequestBody DepartamentoEntity detalleFactura, @PathVariable  Long id) {
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