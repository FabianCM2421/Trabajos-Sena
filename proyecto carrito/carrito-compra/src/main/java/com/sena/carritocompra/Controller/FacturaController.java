package com.sena.carritocompra.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sena.carritocompra.Entity.Factura;
import com.sena.carritocompra.IService.IFacturaService;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("v1/api/factura")
public class FacturaController {
    @Autowired
    private IFacturaService service;

    @GetMapping
    public List<Factura> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public Optional<Factura> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Factura save(@RequestBody Factura factura) {
        return service.save(factura);
    }

    @PutMapping("{id}")
    public void update(@RequestBody Factura factura, @PathVariable Long id) {
        service.update(factura, id);
    }
    @PutMapping("deleted-at/{id}")
    public void deletedAt(@PathVariable Long id) {
        service.deletedAt(id);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
