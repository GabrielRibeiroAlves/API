package apicarros.API.controller;

import apicarros.API.entity.Carro;
import apicarros.API.entity.Permissao;
import apicarros.API.service.CarroService;
import apicarros.API.service.PermissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/permissao")

public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/")
    public List<Permissao> listarTodos()
    {
        return permissaoService.listarTodos();
    }
    @PostMapping("/")
    public Permissao inserir(@RequestBody Permissao permissao)
    {
        return permissaoService.inserir(permissao);
    }
    @PutMapping("/")
    public Permissao alterar(@RequestBody Permissao permissao)
    {
        return permissaoService.alterar(permissao);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id)
    {
        permissaoService.excluir(id);
        return ResponseEntity.ok().build();
    }



}
