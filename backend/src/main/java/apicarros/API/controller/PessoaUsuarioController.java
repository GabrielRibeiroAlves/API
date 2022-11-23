package apicarros.API.controller;

import apicarros.API.dto.PessoaUsuarioRequestDTO;
import apicarros.API.entity.Pessoa;
import apicarros.API.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuario")

public class PessoaUsuarioController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaUsuarioRequestDTO pessoaUsuarioRequestDTO)
    {
        Pessoa pessoa = new PessoaUsuarioRequestDTO().converter(pessoaUsuarioRequestDTO)
        return pessoaService.inserir(pessoa);
    }


}
