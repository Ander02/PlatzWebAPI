/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platz.dao;

import java.util.List;

public interface GenericDaoInterface <T>{
    
    public void cadastrar(T t);
    
    public void alterar(T t);
    
    public List<T> listarTodos(Class<T> entity);
    
    public T buscarPorId(Class<T> entity, Integer id);
    
    public void excluir(T t);  
    
}
