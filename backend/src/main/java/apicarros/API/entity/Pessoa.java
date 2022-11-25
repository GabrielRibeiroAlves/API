package apicarros.API.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pessoa")
@Data

public class Pessoa implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true,cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
    @Setter(value = AccessLevel.NONE)
    private List<PermissaoPessoa> permissaoPessoas;

    private String nome;
    private String email;
    private String senha;
    private String codigoRecuperacaoSenha;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEnviodeCodigo;


    public Pessoa() {

    }

    public void setPermissaoPessoas(List<PermissaoPessoa> pp) {
        for(PermissaoPessoa p:pp )
        {
            p.setPessoa(this);
        }
        this.permissaoPessoas=pp;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissaoPessoas;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
