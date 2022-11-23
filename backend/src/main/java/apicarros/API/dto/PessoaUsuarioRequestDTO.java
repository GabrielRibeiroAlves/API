package apicarros.API.dto;

import apicarros.API.entity.Pessoa;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class PessoaUsuarioRequestDTO {

    private String nome;
    private String email;

    public Pessoa converter(PessoaUsuarioRequestDTO pessoaUsuarioRequestDTO)
    {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaUsuarioRequestDTO,pessoa);
        return pessoa;
    }
}
