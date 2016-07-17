///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.platz.util;
//
//import com.platz.dao.CategoriaDao;
//import com.platz.dao.EventoDao;
//import com.platz.entity.CategoriaEntity;
//import com.platz.entity.EventoEntity;
//import com.platz.http.evento.EventoLeitura;
//import java.util.List;
//
///**
// *
// * @author Anderson
// */
//public class Teste {
//
//    public static void main(String[] args) {
//       
//        List<EventoEntity> entitys = new EventoDao().listarTodos(EventoEntity.class);
//
//        for (EventoLeitura evento : new EventoLeitura().converterLista(entitys)) {
//
//            System.out.println(evento.getNome());
//            System.out.println(evento.getCategoria().getNome());
//
//        }
//
//    }
//
//}
