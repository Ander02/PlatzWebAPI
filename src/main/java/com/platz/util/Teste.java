///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.platz.util;
//
//import com.platz.dao.CategoriaDao;
//import com.platz.entity.CategoriaEntity;
//import java.util.List;
//
///**
// *
// * @author Jose da Cruz
// */
//public class Teste {
//
//    public static void main(String[] args) {
//        
//        try {
//            List<CategoriaEntity> categoriaEntity = new CategoriaDao().buscarPeloNome("e");
//            
//            for (CategoriaEntity item : categoriaEntity) {
//                
//                System.out.println("Id " + item.getId());
//                System.out.println("Nome " + item.getNome());
//            }
//
//        } catch (Exception e) {
//            System.out.println("ERRO MENSAGE" + e.getMessage());
//            System.out.println("ERRO CAUSA" + e.getCause());
//            
//        }
//
//    }
//
//}
