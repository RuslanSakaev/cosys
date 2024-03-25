package ru.sakaev.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sakaev.backend.model.Protocol;
import ru.sakaev.backend.service.ProtocolService;

import java.util.List;

@RestController
@RequestMapping("/api/protocols")
public class ProtocolController {

    private final ProtocolService protocolService;

    @Autowired
    public ProtocolController(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @PostMapping
    public ResponseEntity<Protocol> createProtocol(@RequestBody Protocol protocol) {
        Protocol createdProtocol = protocolService.createProtocol(protocol);
        return new ResponseEntity<>(createdProtocol, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Protocol> getProtocolById(@PathVariable Long id) {
        Protocol protocol = protocolService.getProtocolById(id).orElse(null);
        if (protocol != null) {
            return new ResponseEntity<>(protocol, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Protocol>> getAllProtocols() {
        List<Protocol> protocols = protocolService.getAllProtocols();
        return new ResponseEntity<>(protocols, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Protocol> updateProtocol(@PathVariable Long id, @RequestBody Protocol protocol) {
        Protocol updatedProtocol = protocolService.updateProtocol(id, protocol);
        return new ResponseEntity<>(updatedProtocol, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProtocol(@PathVariable Long id) {
        protocolService.deleteProtocolById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
