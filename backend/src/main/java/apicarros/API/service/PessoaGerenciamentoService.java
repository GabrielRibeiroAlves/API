package apicarros.API.service;

import apicarros.API.entity.Pessoa;
import apicarros.API.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class PessoaGerenciamentoService {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public PessoaGerenciamentoService(PessoaRepository pessoaRepository, EmailService emailService) {
        this.pessoaRepository = pessoaRepository;
        this.emailService = emailService;
    }

    public String solicitarcodigo(String email)
    {

        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigorecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnviodeCodigo(new Date());
        pessoaRepository.saveAndFlush(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(),"CODIGO DE VERIFICACAO DE SENHA",
                "Seu codigo de verificacao de senha é: "+pessoa.getCodigoRecuperacaoSenha());
        return "Codigo enviado para o email "+pessoa.getEmail();
    }

    public String alterarSenha(Pessoa pessoa)
    {

        Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(),pessoa.getCodigoRecuperacaoSenha());

        if(pessoaBanco!=null)
        {
            Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnviodeCodigo().getTime());

            if((diferenca.getTime()/1000)<900)
            {
                pessoaBanco.setSenha(passwordEncoder.encode(pessoa.getSenha()));
                pessoaBanco.setCodigoRecuperacaoSenha(null);
                pessoaRepository.saveAndFlush(pessoaBanco);
                return "Senha alterada com sucesso!";
            }else
            {
                return "Tempo expirou,solicite um novo codigo";
            }
        } else {
            return "Email ou codigo nao encontrado";
        }
    }

    private String getCodigorecuperacaoSenha(Long id)
    {

        DateFormat format= new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date())+id;

    }


}
