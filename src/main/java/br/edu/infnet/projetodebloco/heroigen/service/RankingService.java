package br.edu.infnet.projetodebloco.heroigen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	
	public Boolean calculaRanking(String idBatalha) {

		return true;
	}
	
	public List<ItemRanking> getRanking(){
		return rankingRepository.findAllSorted();
	}

}
