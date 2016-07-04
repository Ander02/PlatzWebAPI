package com.platz.bean;

import com.platz.dao.CategoriaDao;
import com.platz.entity.CategoriaEntity;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class CategoriaBean {

    private final CategoriaDao categoriaDao = new CategoriaDao();

    public void cadastrar(CategoriaEntity entity) {
        categoriaDao.cadastrar(entity);
    }

    public List<CategoriaEntity> listarTodos() {
        return categoriaDao.listarTodos(CategoriaEntity.class);
    }

    public CategoriaEntity buscarPorId(Integer id) {
        return categoriaDao.buscarPorId(CategoriaEntity.class, id);
    }

    public List<CategoriaEntity> buscarPeloNome(String nome) {
        return categoriaDao.buscarPeloNome(nome);
    }
    
    public void alterar(CategoriaEntity entity){
        categoriaDao.alterar(entity);
    }
    
    public void excluir(CategoriaEntity entity){
        categoriaDao.excluir(entity);
    }

}
