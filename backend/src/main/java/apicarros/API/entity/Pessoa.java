package apicarros.API.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoa")
@Data

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;

    private String nome;
    private String email;
    private String senha;
    @Temporal(TemporalType.DATE)
    private String codigoRecuperacaoSenha;
    private Date dataEnviodeCodigo;

    public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
        for(PermissaoPessoa p:pp )
        {
            p.setPessoa(this);
        }
        this.permissaoPessoas=pp;

    }
}
