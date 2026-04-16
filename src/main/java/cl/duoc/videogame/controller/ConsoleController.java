package cl.duoc.videogame.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.videogame.dto.ConsoleDTO;
import cl.duoc.videogame.service.ConsoleService;

@RestController
@RequestMapping("api/v1/console")
public class ConsoleController {

    private final ConsoleService consoleService;

    public ConsoleController(ConsoleService consoleService){
        this.consoleService = consoleService;
    }

    @GetMapping
    public ResponseEntity<List<ConsoleDTO>> findAll(){
        return ResponseEntity.ok(consoleService.findAll());
    }
    @GetMapping
    public ResponseEntity<ConsoleDTO> create(RequestBody ConsoleDTO consoleDTO){
        return ResponseEntity.ok(consoleService.create(consoleDTO));
    }


}
