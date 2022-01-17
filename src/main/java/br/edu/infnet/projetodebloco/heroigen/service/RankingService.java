package br.edu.infnet.projetodebloco.heroigen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.edu.infnet.projetodebloco.heroigen.model.ItemRanking;
import br.edu.infnet.projetodebloco.heroigen.repository.RankingRepository;
import lombok.Getter;

@Service
@Getter
public class RankingService {
	
	@Autowired
	RankingRepository rankingRepository;
	
	private String errorMessage;
	
	public Boolean calculaRanking(Integer batalhaId) {

		return true;
	}
	
	@Cacheable( cacheNames="rankingItem", key="#root.method.name" )
	public List<ItemRanking> getRanking(){
		return rankingRepository.findAllSorted();
	}

	public ItemRanking getRanking(Integer batalhaId) {
		return this.rankingRepository.getById(batalhaId);
	}

}
