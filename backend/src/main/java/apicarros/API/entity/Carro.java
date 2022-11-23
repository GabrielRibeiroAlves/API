package apicarros.API.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "carro")
@Data

public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name= "idCategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idPessoa")
    private Pessoa pessoa;

    private String modelo;
    private String ano;
    private String motor;
    private String valor;

}
