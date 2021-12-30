package com.dargas.rh.service;

import com.dargas.rh.model.entities.Candidato;
import com.dargas.rh.repository.CandidatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    private final CandidatoRepository candidatoRepository;

    public CandidatoServiceImpl(CandidatoRepository candidatoRepository){
        this.candidatoRepository = candidatoRepository;
    }

    @Override
    public List<Candidato> getAll() {
        return candidatoRepository.findAll();
    }

    @Override
    public Candidato getById(String id){
        return candidatoRepository.findById(id).get();
    }

    @Override
    public Candidato update(String id, Candidato candidato) {
        candidato.setId(id);
        return candidatoRepository.save(candidato);
    }

    @Override
    public Candidato create(Candidato candidato){
        return candidatoRepository.save(candidato);
    }

    @Override
    public void delete(String id) {
        candidatoRepository.delete(candidatoRepository.findById(id).get());
    }
}
