/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platz.http.evento;

import com.platz.entity.EventoEntity;
import com.platz.http.categoria.CategoriaLeitura;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anderson
 */
@XmlRootElement
public class EventoLeitura {

    //Propriedades
    private int id;
    private String nome;
    private CategoriaLeitura categoria;

    //Construtores
    public EventoLeitura() {
    }

    public EventoLeitura(int id, String nome, CategoriaLeitura categoria) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
    }

    public EventoLeitura(EventoEntity entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.categoria = new CategoriaLeitura(entity.getCategoria());
    }

    //Métodos
    public List<EventoLeitura> converterLista(List<EventoEntity> entitysList) {

        List<EventoLeitura> lista = new ArrayList<>();

        for (EventoEntity entity : entitysList) {

            EventoLeitura evento;
            evento = new EventoLeitura(entity);

            lista.add(evento);
        }

        return lista;

    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CategoriaLeitura getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaLeitura categoria) {
        this.categoria = categoria;
    }

}
