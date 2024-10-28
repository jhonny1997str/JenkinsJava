package com.JavaJenkins.controlador;



import com.JavaJenkins.entidad.Cliente;
import com.JavaJenkins.repositorio.ClienteRepositorio;
import com.JavaJenkins.service.ClienteServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/clientes")
public class ClienteControlador {
    private final ClienteServicio clienteServicio;


    @GetMapping
    public List<Cliente> findAll() {
        return clienteServicio.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable Long id){
        return clienteServicio.findById(id);
    }

    @PostMapping
    public Cliente save(@RequestBody Cliente cliente) {
        return clienteServicio.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        clienteServicio.delete(id);

    }
}