/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platz.http.categoria;

import com.platz.entity.CategoriaEntity;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Anderson
 */
@XmlRootElement
public class CategoriaLeitura {

    private int id;
    private String nome;

    //Construtores
    public CategoriaLeitura() {

    }

    public CategoriaLeitura(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaLeitura(CategoriaEntity categoriaEntity) {
        this.id = categoriaEntity.getId();
        this.nome = categoriaEntity.getNome();
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

    //Métodos
    public List<CategoriaLeitura> converterLista(List<CategoriaEntity> entityList) {

        List<CategoriaLeitura> lista = new ArrayList<>();

        for (CategoriaEntity entity : entityList) {

            CategoriaLeitura categoria = new CategoriaLeitura(entity);
            lista.add(categoria);
        }
        return lista;
    }

}
