package cl.duoc.videogame.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.videogame.dto.CompanieDTO;
import cl.duoc.videogame.service.CompanieService;

@RestController
@RequestMapping("api/v1/companies")
public class CompanieController {

    private final CompanieService companieService;

    public CompanieController(CompanieService companieService){
        this.companieService = companieService;
    }

    @PostMapping
    public ResponseEntity<CompanieDTO> create(@RequestBody CompanieDTO companieDTO){
        return ResponseEntity.ok(companieService.create(companieDTO));
    }

    @GetMapping
    public ResponseEntity<List<CompanieDTO>> findAll(){
        return ResponseEntity.ok(companieService.findAll());
    }

    @GetMapping("/(id)")
        public ResponseEntity<CompanieDTO> findById(@PathVariable Long id){
            return ResponseEntity.ok(companieService.findById(id));
        }

    @DeleteMapping("/(id)")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        companieService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
