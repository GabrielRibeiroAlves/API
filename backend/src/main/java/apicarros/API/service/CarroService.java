package apicarros.API.service;

import apicarros.API.entity.Carro;
import apicarros.API.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarTodosCarros()
    {
        return carroRepository.findAll();
    }

    public Carro inserir(Carro carro)
    {
            Carro carronovo = carroRepository.saveAndFlush(carro);
            return carronovo;
    }

    public Carro alterar(Carro carro)
    {
        return carroRepository.saveAndFlush(carro);
    }

    public void excluir(Long id)
    {
        Carro carro = carroRepository.findById(id).get();
        carroRepository.delete(carro);
    }

}
