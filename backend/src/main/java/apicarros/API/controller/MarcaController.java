package apicarros.API.controller;

import apicarros.API.entity.Carro;
import apicarros.API.entity.Marca;
import apicarros.API.service.CarroService;
import apicarros.API.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/marca")

public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping("/")
    public List<Marca> listarTodos()
    {
        return marcaService.listarTodos();
    }
    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca)
    {
        return marcaService.inserir(marca);
    }
    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca)
    {
        return marcaService.alterar(marca);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id)
    {
        marcaService.excluir(id);
        return ResponseEntity.ok().build();
    }



}
