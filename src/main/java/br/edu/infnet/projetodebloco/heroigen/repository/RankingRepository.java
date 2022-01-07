package br.edu.infnet.projetodebloco.heroigen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.infnet.projetodebloco.heroigen.model.ItemRanking;

@Repository
public interface RankingRepository extends JpaRepository<ItemRanking, Integer> {

	@Query("select r from ItemRanking r where 1=1 order by posicao asc")
	List<ItemRanking> findAllSorted();

//	@Query("select i from ItemLog i where i.id_batalha = ?1 order by id_batalha asc")
//	List<ItemRanking> findBatalha(Integer id_batalha);
	
}
