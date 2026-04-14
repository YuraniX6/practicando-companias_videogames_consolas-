package cl.duoc.videogame.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.duoc.videogame.model.Companies;

public interface CompanieRepository extends JpaRepository<Companies, Long>{

}
