package apicarros.API.repository;

import apicarros.API.entity.Carro;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Long> {
}
