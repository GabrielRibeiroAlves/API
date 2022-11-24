package apicarros.API.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "permissaopessoa")
@Data
public class PermissaoPessoa implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "idPermissao")
    private Permissao permissao;

    @Override
    public String getAuthority() {
        return permissao.getPermissao();
    }
}
