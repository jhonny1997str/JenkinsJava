package com.JavaJenkins.service;

import com.JavaJenkins.entidad.Cliente;

import java.util.List;

public interface ClienteServicio {
    public List<Cliente>findAll();
    public Cliente findById(Long id);
    public Cliente save(Cliente cliente);
    public void delete(Long id);

}
