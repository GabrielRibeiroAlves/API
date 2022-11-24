package apicarros.API.repository;


import apicarros.API.entity.PermissaoPessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PermissaoPessoaRepository extends JpaRepository<PermissaoPessoa,Long> {


}
