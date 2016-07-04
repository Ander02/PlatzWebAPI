/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platz.controller;

import com.platz.bean.CategoriaBean;
import com.platz.entity.CategoriaEntity;
import com.platz.http.categoria.CategoriaCadastro;
import com.platz.http.categoria.CategoriaEdicao;
import com.platz.http.categoria.CategoriaLeitura;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Anderson
 */
@Path("")
public class CategoriaController {

    private final CategoriaBean categoriaBean = new CategoriaBean();

    @POST
    @Path("/categoria")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response cadastrar(CategoriaCadastro categoria) {

        // Instanciar Entity
        CategoriaEntity entity = new CategoriaEntity();

        try {
            // Settar o nome da entity baseado no nome da categoria passada
            entity.setNome(categoria.getNome());

            // Cadastrar categoria
            categoriaBean.cadastrar(entity);

            // Retorna a resposta para o cliente com o Status Code CREATED e a Categoria de Leitura     
            return Response.status(Response.Status.CREATED).entity(new CategoriaLeitura(entity)).build();

        } catch (Exception e) {
            // Envia erro pelo console
            System.out.println("Erro: " + e.getMessage());
            //Retorna uma BadRequest ao usuário
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao cadastrar categoria").build();
        }
    }

    @GET
    @Path("/categorias")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response listarTodos() {
        try {
            //Lista com todas as CategoriaEntity cadastradas
            List<CategoriaEntity> entidades = categoriaBean.listarTodos();

            //Lista de Categorias de Leitura baseado na lista de entidades
            List<CategoriaLeitura> listaDeCategorias = new CategoriaLeitura().converterLista(entidades);

            //Retorna a lista com um Status Code OK
            return Response.ok(listaDeCategorias).build();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            //Retorna uma BadRequest ao usuário
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao listar categorias").build();
        }
    }

    @GET
    @Path("/categoria/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response buscarPeloId(@PathParam("id") Integer id) {

        //Busca uma entidade baseado pelo id
        CategoriaEntity entity = categoriaBean.buscarPorId(id);

        //Verifica se a entidade returnada não é nula
        if (entity != null) {

            //Retorna um Status Code OK com a categoria de leitura
            return Response.ok(new CategoriaLeitura(entity)).build();

        }

        //Se a entity for nula retorna um Status Code Not Found 
        return Response.status(Response.Status.NOT_FOUND).entity("Categoria não encontrada").build();
    }

    @GET
    @Path("/categorias/{nome}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response buscarPeloNome(@PathParam("nome") String nome) {

        try {

            //Buscar Entitys pelo nome
            List<CategoriaEntity> entidades = categoriaBean.buscarPeloNome(nome);

            //Lista de Categorias de Leitura baseado na lista de entidades
            List<CategoriaLeitura> listaDeCategorias = new CategoriaLeitura().converterLista(entidades);

            //Retorna a lista com um Status Code OK
            return Response.ok(listaDeCategorias).build();

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            //Retorna uma BadRequest ao usuário
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao listar categorias").build();
        }
    }

    @PUT
    @Path("/categoria/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response alterar(@PathParam("id") Integer id, CategoriaEdicao categoria) {

        CategoriaEntity entity = new CategoriaEntity();

        try {

            //Settar informações na entity
            entity.setId(id);
            entity.setNome(categoria.getNome());

            //Alterar registro
            categoriaBean.alterar(entity);

            //Retorna Status Code OK com a entity de leitura com a modificação
            return Response.status(Response.Status.OK).entity(new CategoriaLeitura(entity)).build();

        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar categoria").build();
        }
    }

    @DELETE
    @Path("/categoria/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response deletar(@PathParam("id") Integer id) {

        try {

            CategoriaEntity entity = categoriaBean.buscarPorId(id);

            categoriaBean.excluir(entity);

            return Response.status(Response.Status.NO_CONTENT).build();

        } catch (Exception e) {
            System.out.println("Erro" + e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity("Erro ao alterar categoria").build();
        }

    }

}
