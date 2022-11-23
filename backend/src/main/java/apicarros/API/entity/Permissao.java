package apicarros.API.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "permissoes")
@Data

public class Permissao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String permissao;

}
