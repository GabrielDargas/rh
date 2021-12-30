package com.dargas.rh.service;

import com.dargas.rh.model.entities.Candidato;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CandidatoService {
    List<Candidato> getAll();
    Candidato getById(String id);
    Candidato update(String id, Candidato candidato);
    Candidato create(Candidato candidato);
    void delete(String id);
}
