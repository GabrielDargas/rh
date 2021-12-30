package com.dargas.rh.controllers;


import com.dargas.rh.model.dto.CandidatoDto;
import com.dargas.rh.model.entities.Candidato;
import com.dargas.rh.service.CandidatoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/candidatos")
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {this.candidatoService = candidatoService;
    }

   @GetMapping
    public ResponseEntity<List<CandidatoDto>> getAll(){
        List<Candidato> list = candidatoService.getAll();
        List<CandidatoDto> candidatoDto = new LinkedList<CandidatoDto>();

        list.forEach(i ->{
            CandidatoDto p = new CandidatoDto();
            p.setNomeCompleto(i.getNomeCompleto());
            p.setTelefones(i.getTelefones());
            p.setTelefones2(i.getTelefones2());
            p.setTelefones3(i.getTelefones3());
            p.setTelefones4(i.getTelefones4());
            p.setTelefones5(i.getTelefones5());
            candidatoDto.add(p);
        });
            return  ResponseEntity.ok(candidatoDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<Candidato> getById(@PathVariable("id") String id) {
        try{
            Candidato candidato =  candidatoService.getById(id);
            if (candidato == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(candidato);
        }catch (NoSuchElementException ex){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Candidato> create(@RequestBody CandidatoDto candidatoDto){
        Candidato candidato = candidatoService.create(new Candidato(candidatoDto));
        return ResponseEntity
                .created(URI.create("/candidato"+candidato.getId()))
                .body(candidato);
    }

    @PutMapping("{id}")
    public Candidato update(@PathVariable("id") String id, @RequestBody CandidatoDto candidatoDto) {
        try{
            Candidato candidato = candidatoService.getById(id);
            if (candidatoService == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
            }
            return candidatoService.update(id, new Candidato(candidatoDto));
        }catch (NoSuchElementException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Foo Not Found");
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable String id) {

        candidatoService.delete(id);
        return ResponseEntity.ok("Registro deletado com sucesso!");
    }

}
