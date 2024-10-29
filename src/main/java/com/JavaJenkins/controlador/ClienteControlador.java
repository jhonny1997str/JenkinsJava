package com.JavaJenkins.controlador;



import com.JavaJenkins.entidad.Cliente;
import com.JavaJenkins.service.ClienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {
    @Autowired
    private final ClienteServicio clienteServicio;


    @GetMapping
    public List<Cliente> findAll() {
        return clienteServicio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){
        Cliente cliente = clienteServicio.findById(id);
        if (cliente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  // Retorna 404 si no se encuentra.
        }
        return ResponseEntity.ok(cliente);  // Retorna el cliente si se encuentra.
    }


    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteServicio.save(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            clienteServicio.delete(id);
            return ResponseEntity.noContent().build();  // Devuelve 204 No Content
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // Devuelve 404 Not Found
        }
    }

}