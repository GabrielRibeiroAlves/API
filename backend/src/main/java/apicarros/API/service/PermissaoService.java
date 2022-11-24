package apicarros.API.service;


import apicarros.API.entity.Permissao;
import apicarros.API.repository.PermissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PermissaoService {

    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> listarTodos()
    {
        return permissaoRepository.findAll();
    }

    public Permissao inserir(Permissao permissao)
    {
        Permissao novapermisao = permissaoRepository.saveAndFlush(permissao);
        return novapermisao;
    }

    public Permissao alterar(Permissao permisao)
    {
        return permissaoRepository.saveAndFlush(permisao);
    }

    public void excluir(Long id)
    {
        Permissao permissao = permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);
    }

}
