package apicarros.API.repository;

import apicarros.API.entity.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao,Long> {

    List<Permissao> findByPermissao(String permissao);

}
