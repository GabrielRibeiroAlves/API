package apicarros.API.controller;


import apicarros.API.entity.Pessoa;
import apicarros.API.security.JwtUtil;
import apicarros.API.service.PessoaGerenciamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoa-gerenciamento")

public class PessoaGerenciamentoController {

    @Autowired
    private PessoaGerenciamentoService pessoaGerenciamentoService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/recuperar-codigo")
    public String recuperarCodigo(@RequestBody Pessoa pessoa)
    {
        return pessoaGerenciamentoService.solicitarcodigo(pessoa.getEmail());
    }
    @PostMapping("/alterar-senha")
    public String alterarSenha(@RequestBody Pessoa pessoa)
    {
        return pessoaGerenciamentoService.alterarSenha(pessoa);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Pessoa pessoa)
    {
        Authentication  authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(pessoa.getEmail(),pessoa.getSenha()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Pessoa autenticado = (Pessoa) authentication.getPrincipal();
        String token =jwtUtil.gerarTokenUsername(autenticado);
        return ResponseEntity.ok(token);
     }

}
