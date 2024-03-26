package ru.sakaev.webclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import ru.sakaev.webclient.entity.Protocol;
import ru.sakaev.webclient.services.ProtocolService;

import java.util.List;

@Controller
public class ProtocolController {

    private final ProtocolService protocolService;

    @Autowired
    public ProtocolController(ProtocolService protocolService) {
        this.protocolService = protocolService;
    }

    @GetMapping("/protocols")
    public String getProtocols(Model model) {
        Flux<Protocol> protocolFlux = protocolService.getAllProtocols();
        List<Protocol> protocols = protocolFlux.collectList().block();
        model.addAttribute("protocols", protocols);
        return "protocols";
    }
}
