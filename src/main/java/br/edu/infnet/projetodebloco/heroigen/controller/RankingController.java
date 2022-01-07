package br.edu.infnet.projetodebloco.heroigen.controller;


import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value = "/")
	public ResponseEntity<String> getRanking() {
		
		List<ItemRanking> ranking = rankingService.getRanking();
		
		if (ranking.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Ranking vazio!");
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON).body(ranking.toString());
	}
	
	@PostMapping(value = "/salvaranking", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> gravarRanking(@Valid @RequestBody RankingRequest request) throws URISyntaxException {

		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		log.info("\n\n A batalha a ser rankeada é:\n{}", request.getIdBatalha());
		
		if (!rankingService.calculaRanking(request.getIdBatalha())) {
			response = ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN)
			.body(rankingService.getErrorMessage());
		} else {
			response = ResponseEntity.created(null).contentType(MediaType.TEXT_PLAIN)
					.body("Inserido no ranking com sucesso!");
		}
			
		return response;
	}
}
