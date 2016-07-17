/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platz.controller;

import com.platz.bean.EventoBean;
import com.platz.entity.EventoEntity;
import com.platz.http.evento.EventoLeitura;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Anderson
 */
@Path("")
public class EventoController {

    private final EventoBean eventoBean = new EventoBean();

    @GET
    @Path("/eventos")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response listarTodos() {

        try {

            //Lista com todas as EventoEntity cadastradas
            List<EventoEntity> entidades = eventoBean.listarTodos();

            //Lista de Eventos de Leitura baseado na lista de entidades
            List<EventoLeitura> listaDeEventos = new EventoLeitura().converterLista(entidades);

            //Retorna a lista com um Status Code OK
            return Response.ok(listaDeEventos).build();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.println("Message: " + e.getMessage());
            //Retorna uma BadRequest ao usuário
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao listar eventos").build();
        }
    }

}
