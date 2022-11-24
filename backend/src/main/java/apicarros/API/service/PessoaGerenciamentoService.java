package apicarros.API.service;

import apicarros.API.dto.PessoaUsuarioRequestDTO;
import apicarros.API.entity.Pessoa;
import apicarros.API.repository.PessoaRepository;
import apicarros.API.repository.PessoaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.DataTruncation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class PessoaGerenciamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    public String solicitarcodigo(String email)
    {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        pessoa.setCodigoRecuperacaoSenha(getCodigorecuperacaoSenha(pessoa.getId()));
        pessoa.setDataEnviodeCodigo(new Data());
        pessoaRepository.saveAndFlush(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(),"CODIGO DE VERIFICACAO DE SENHA",
                "Seu codigo de verificacao de senha é:"+pessoa.getCodigoRecuperacaoSenha());
        return "Codigo enviado!";
    }


    private String getCodigorecuperacaoSenha(Long id)
    {
        DateFormat format= new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date())+id;

    }

}
