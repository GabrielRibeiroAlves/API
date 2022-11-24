package apicarros.API.repository;

import apicarros.API.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaUsuarioRepository extends JpaRepository<Pessoa,Long> {
}
