package br.edu.infnet.projetodebloco.heroigen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.projetodebloco.heroigen.model.ItemLog;

@Repository
public interface LogRepository extends JpaRepository<ItemLog, Integer> {

	@Query("select i from ItemLog i where 1=1 order by id_batalha asc")
	List<ItemLog> findAllSorted();

	@Query("select i from ItemLog i where i.id_batalha = ?1 order by id_batalha asc")
	List<ItemLog> findBatalha(Integer id_batalha);
	
}
