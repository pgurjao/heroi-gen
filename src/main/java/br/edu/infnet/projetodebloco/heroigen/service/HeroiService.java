package br.edu.infnet.projetodebloco.heroigen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.projetodebloco.heroigen.enums.HeroisEnum;
import br.edu.infnet.projetodebloco.heroigen.model.Heroi;
import br.edu.infnet.projetodebloco.heroigen.repository.HeroiRepository;
import lombok.Getter;

@Getter
@Service
public class HeroiService {
	
	private String errorMessage;
	
	@Autowired
	private HeroiRepository heroiRepository;
	
	public Optional<Heroi> getByHeroi(HeroisEnum heroiEnum) {
		return heroiRepository.findByHeroi(heroiEnum);
	}
	
	public List<Heroi> findAll(){
		return heroiRepository.findAll();
	}

}
