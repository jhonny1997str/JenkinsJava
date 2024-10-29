package com.JavaJenkins;

import com.JavaJenkins.controlador.ClienteControlador;
import com.JavaJenkins.entidad.Cliente;
import com.JavaJenkins.service.ClienteServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteControladorTest {

    private ClienteControlador clienteControlador;
    private ClienteServicio clienteServicio;

    @BeforeEach
    void setUp() {
        clienteServicio = Mockito.mock(ClienteServicio.class);
        clienteControlador = new ClienteControlador(clienteServicio);
    }

    @Test
    void testFindById_ReturnsCliente_WhenExists() {
        // Arrange
        Long clienteId = 1L;
        Cliente cliente = new Cliente(clienteId, "Juan", "juan@example.com");
        when(clienteServicio.findById(clienteId)).thenReturn(cliente); // Cambiar Optional por Cliente

        // Act
        ResponseEntity<Cliente> response = clienteControlador.findById(clienteId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    void testFindById_ReturnsNotFound_WhenDoesNotExist() {
        // Arrange
        Long clienteId = 1L;
        when(clienteServicio.findById(clienteId)).thenReturn(null); // Cambiar Optional por null

        // Act
        ResponseEntity<Cliente> response = clienteControlador.findById(clienteId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void testDelete_ReturnsNoContent_WhenDeletedSuccessfully() {
        // Arrange
        Long clienteId = 1L;
        doNothing().when(clienteServicio).delete(clienteId);

        // Act
        ResponseEntity<Void> response = clienteControlador.delete(clienteId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void testDelete_ReturnsNotFound_WhenClienteDoesNotExist() {
        // Arrange
        Long clienteId = 1L;
        doThrow(new RuntimeException("Customer not found")).when(clienteServicio).delete(clienteId);

        // Act
        ResponseEntity<Void> response = clienteControlador.delete(clienteId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}
