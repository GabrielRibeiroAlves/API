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
        pessoa.setDataEnviodeCodigo(new Date());
        pessoaRepository.saveAndFlush(pessoa);
        emailService.enviarEmailTexto(pessoa.getEmail(),"CODIGO DE VERIFICACAO DE SENHA",
                "Seu codigo de verificacao de senha é:"+pessoa.getCodigoRecuperacaoSenha());
        return "Codigo enviado!";
    }

    public String alterarSenha(Pessoa pessoa)
    {

        Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigCoRecuperacaoSenha(pessoa.getEmail(),pessoa.getCodigoRecuperacaoSenha());
        if(pessoaBanco!=null)
        {
            Date diferenca = new Date(new Date().getTime() - pessoaBanco.getDataEnviodeCodigo().getTime());

            if((diferenca.getTime()/1000)<900)
            {
                pessoaBanco.setSenha(pessoa.getSenha());
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
