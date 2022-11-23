package apicarros.API.service;

import apicarros.API.entity.Carro;
import apicarros.API.entity.Categoria;
import apicarros.API.repository.CarroRepository;
import apicarros.API.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodos()
    {
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria)
    {
        Categoria novacategoria = categoriaRepository.saveAndFlush(categoria);
        return novacategoria;
    }

    public Categoria alterar(Categoria categoria)
    {
        return categoriaRepository.saveAndFlush(categoria);
    }

    public void excluir(Long id)
    {
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }

}
