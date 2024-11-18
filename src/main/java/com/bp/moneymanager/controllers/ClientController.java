package com.bp.moneymanager.controllers;

import com.bp.moneymanager.dto.ClientRequestDto;
import com.bp.moneymanager.mapper.ClientMapper;
import com.bp.moneymanager.models.Client;
import com.bp.moneymanager.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity<Client> create(@Valid @RequestBody ClientRequestDto clientRequestDto) {
        Client client = clientMapper.toClient(clientRequestDto);
        return new ResponseEntity<>(clientService.create(client), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @Valid @RequestBody ClientRequestDto clientRequestDto) {
        Client client = clientMapper.toClient(clientRequestDto);
        return new ResponseEntity<>(clientService.update(id, client), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id) {
        return new ResponseEntity<>(clientService.delete(id), HttpStatus.OK);
    }
}
