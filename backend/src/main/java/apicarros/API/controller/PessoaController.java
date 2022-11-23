package apicarros.API.controller;

import apicarros.API.entity.Carro;
import apicarros.API.entity.Pessoa;
import apicarros.API.service.CarroService;
import apicarros.API.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/pessoa")

public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/")
    public List<Pessoa> listarTodos()
    {
        return pessoaService.listarTodos();
    }
    @PostMapping("/")
    public Pessoa inserir(@RequestBody Pessoa pessoa)
    {
        return pessoaService.inserir(pessoa);
    }
    @PutMapping("/")
    public Pessoa alterar(@RequestBody Pessoa pessoa)
    {
        return pessoaService.alterar(pessoa);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id)
    {
        pessoaService.excluir(id);
        return ResponseEntity.ok().build();
    }



}
