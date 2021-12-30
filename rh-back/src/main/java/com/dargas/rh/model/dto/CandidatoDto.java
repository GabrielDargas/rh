package com.dargas.rh.model.dto;

import com.dargas.rh.model.entities.Telefone;
import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class CandidatoDto {
    private String nomeCompleto;
    private List<Telefone> telefones;
    private List<Telefone> telefones2;
    private List<Telefone> telefones3;
    private List<Telefone> telefones4;
    private List<Telefone> telefones5;
    private List<Telefone> todosTelefones;
}
