package apicarros.API.service;

import apicarros.API.entity.Carro;
import apicarros.API.entity.Marca;
import apicarros.API.entity.Pessoa;
import apicarros.API.repository.CarroRepository;
import apicarros.API.repository.MarcaRepository;
import apicarros.API.repository.PermissaoRepository;
import apicarros.API.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listarTodos()
    {
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa)
    {
        Pessoa novapessoa = pessoaRepository.saveAndFlush(pessoa);
        return novapessoa;
    }

    public Pessoa alterar(Pessoa pessoa)
    {
        return pessoaRepository.saveAndFlush(pessoa);
    }

    public void excluir(Long id)
    {
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }

}
