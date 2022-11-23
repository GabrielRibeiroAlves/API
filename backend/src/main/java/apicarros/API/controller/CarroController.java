package apicarros.API.controller;

import apicarros.API.entity.Carro;
import apicarros.API.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/carro")

public class CarroController {

    @Autowired
    private CarroService carroService;

    @GetMapping("/")
    public List<Carro> listarTodos()
    {
        return carroService.listarTodosCarros();
    }
    @PostMapping("/")
    public Carro inserir(@RequestBody Carro carro)
    {
        return carroService.inserir(carro);
    }
    @PutMapping("/")
    public Carro alterar(@RequestBody Carro carro)
    {
        return carroService.alterar(carro);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id)
    {
        carroService.excluir(id);
        return ResponseEntity.ok().build();
    }



}
