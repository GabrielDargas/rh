package com.dargas.rh.model.entities;


import com.dargas.rh.model.dto.CandidatoDto;
import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Document(collection = "candidatos")
public class Candidato {

    @Id
    private String id;
    @Field(name = "Nome Completo")
    private String nomeCompleto;
    @Field(name="Telefone")
    private List<Telefone> telefones;
    @Field(name="Telefone - Work")
    private List<Telefone> telefones2;
    @Field(name="Telefone - Other")
    private List<Telefone> telefones3;
    @Field(name="Telefone - Home")
    private List<Telefone> telefones4;
    @Field(name="Telefone - Main")
    private List<Telefone> telefones5;


    public Candidato(CandidatoDto candidatoDto) {
        ObjectId id = new ObjectId();
        this.setId(id.toString());
        this.nomeCompleto = candidatoDto.getNomeCompleto();
    }


}


