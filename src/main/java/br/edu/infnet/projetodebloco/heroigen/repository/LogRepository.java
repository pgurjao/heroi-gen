package br.edu.infnet.projetodebloco.heroigen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.projetodebloco.heroigen.model.Turno;

@Repository
public interface LogRepository extends JpaRepository<Turno, Integer> {

	@Query("select t from Turno t where 1=1 order by t.ranking.batalhaId asc")
	List<Turno> findAllOrderByBatalhaIdAsc();

//	@Query("select i from ItemLog i where i.id_batalha = ?1 order by i.ranking.batalhaId asc")
//	List<Turno> findByBatalhaId(Integer id_batalha);
	
	@Query("from Turno t where t.ranking.batalhaId = :id_batalha and t.usuario = :nomeUsuario order by t.ranking.batalhaId asc")
	List<Turno> findBatalha( @Param("id_batalha") Integer id_batalha, @Param("nomeUsuario") String nomeUsuario );
	
}
