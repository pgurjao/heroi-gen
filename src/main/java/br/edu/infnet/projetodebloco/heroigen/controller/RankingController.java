package br.edu.infnet.projetodebloco.heroigen.controller;


import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.projetodebloco.heroigen.model.ItemRanking;
import br.edu.infnet.projetodebloco.heroigen.request.RankingRequest;
import br.edu.infnet.projetodebloco.heroigen.service.RankingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/ranking")
public class RankingController {
	
	@Autowired
	RankingService rankingService;
	
	@GetMapping(value = "")
	public ResponseEntity<String> getRanking() {
		
		List<ItemRanking> ranking = rankingService.getRanking();
		
		if (ranking.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Ranking vazio!");
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON).body(ranking.toString());
	}
	
	@PostMapping(value = "/{batalhaId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> gravarBatalha(@Valid @PathVariable("batalhaId") Integer batalhaId) {

		log.info("\n\n A batalha a ser rankeada é:\n{}", batalhaId);
		
		if (!rankingService.calculaRanking(batalhaId)) {
			return ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN)
			.body(rankingService.getErrorMessage());
		} else {
			return ResponseEntity.created(null).contentType(MediaType.TEXT_PLAIN)
					.body("Inserido no ranking com sucesso!");
		}
	}
}
