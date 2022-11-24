package apicarros.API.service;

import apicarros.API.dto.PessoaUsuarioRequestDTO;
import apicarros.API.entity.Pessoa;
import apicarros.API.repository.PermissaoRepository;
import apicarros.API.repository.PessoaRepository;
import apicarros.API.repository.PessoaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PessoaUsuarioService {

    @Autowired
    private PessoaUsuarioRepository pessoaUsuarioRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;


    public Pessoa registrar(PessoaUsuarioRequestDTO pessoaUsuarioRequestDTO)
    {
        Pessoa pessoa = new PessoaUsuarioRequestDTO().converter(pessoaUsuarioRequestDTO)

        Pessoa novapessoa = pessoaUsuarioRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoClient(novapessoa);
        return novapessoa;
    }

}
