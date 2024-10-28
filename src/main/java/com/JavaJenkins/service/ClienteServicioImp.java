package com.JavaJenkins.service;

import com.JavaJenkins.entidad.Cliente;
import com.JavaJenkins.repositorio.ClienteRepositorio;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ClienteServicioImp implements  ClienteServicio{
    private final ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> findAll(){
        return  clienteRepositorio.findAll();
    }

    @Override
    public Cliente findById(Long id){
        return  clienteRepositorio.findById(id).orElse(null);
    }

    @Override
    public Cliente save(Cliente cliente){
        return  clienteRepositorio.save(cliente);
    }

    @Override
    public void delete(Long id){
        if (!clienteRepositorio.existsById(id)){
            throw  new RuntimeException("Customer not found");
        }
        clienteRepositorio.deleteById(id);
    }


}