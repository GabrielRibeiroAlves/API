package apicarros.API.service;


import apicarros.API.entity.Permissao;
import apicarros.API.entity.PermissaoPessoa;
import apicarros.API.entity.Pessoa;
import apicarros.API.repository.PermissaoPessoaRepository;
import apicarros.API.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    public void vincularPessoaPermissaoClient(Pessoa pessoa)
    {
        List<Permissao> listaPermissao = permissaoRepository.findByPermissao("usuario");
        if(listaPermissao.size()>0)
        {
            PermissaoPessoa permissaoPessoa =new PermissaoPessoa();
            permissaoPessoa.setPessoa(pessoa);
            permissaoPessoa.setPermissao(listaPermissao.get(0));
            permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    }

}
