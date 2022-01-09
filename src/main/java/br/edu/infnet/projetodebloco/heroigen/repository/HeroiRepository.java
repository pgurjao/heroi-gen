package br.edu.infnet.projetodebloco.heroigen.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.projetodebloco.heroigen.model.Heroi;

@Repository
public interface HeroiRepository extends JpaRepository<Heroi, Integer> {

	Optional<Heroi> findById(Integer idHeroi);

	List<Heroi> findAll();

//	@Query("select h from heroi h where heroi = ?1")
//	Optional<Heroi> findByHeroi(Integer id);

//	@Query("select h from heroi h where h.heroi = ?1")
//	Optional<Heroi> findById(Integer id);

//	@Query("select h from heroi h where 1=1 order by heroi asc")
//	@Query("select h from heroi h where 1=1")
}
