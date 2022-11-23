package apicarros.API.repository;

import apicarros.API.entity.Carro;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CarroRepository extends JpaRepository<Carro,Long> {
}
