package apicarros.API.service;

import apicarros.API.entity.Marca;
import apicarros.API.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarTodos()
    {
        return marcaRepository.findAll();
    }

    public Marca inserir(Marca marca)
    {
        Marca novamarca = marcaRepository.saveAndFlush(marca);
        return novamarca;
    }

    public Marca alterar(Marca marca)
    {
        return marcaRepository.saveAndFlush(marca);
    }

    public void excluir(Long id)
    {
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }

}
