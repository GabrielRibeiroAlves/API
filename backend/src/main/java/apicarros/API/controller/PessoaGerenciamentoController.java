package apicarros.API.controller;

import apicarros.API.dto.PessoaUsuarioRequestDTO;
import apicarros.API.entity.Pessoa;
import apicarros.API.service.PessoaGerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa-gerenciamento")

public class PessoaGerenciamentoController {

    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;

    @PostMapping("/recuperar-codigo")
    public String recuperarCodigo(@RequestBody Pessoa pessoa)
    {
        return pessoaGerenciamentoService.solicitarcodigo(pessoa.getEmail());
    }
    @PostMapping("/alterar-senha")
    public String alterarSenha(@RequestBody Pessoa pessoa)
    {
        return pessoaGerenciamentoService.solicitarcodigo(pessoa);
    }


}
