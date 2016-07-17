/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platz.bean;

import com.platz.dao.CategoriaDao;
import com.platz.dao.EventoDao;
import com.platz.entity.EventoEntity;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class EventoBean {
    
    private final EventoDao eventoDao = new EventoDao();
    
    public void cadastrar(EventoEntity entity){
        eventoDao.cadastrar(entity);
    }
    
    public List<EventoEntity> listarTodos(){
        return eventoDao.listarTodos(EventoEntity.class);
    }
    
    
    
    
}
