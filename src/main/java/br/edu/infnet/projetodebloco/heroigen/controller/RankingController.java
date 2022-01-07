package br.edu.infnet.projetodebloco.heroigen.controller;


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

import br.edu.infnet.projetodebloco.heroigen.request.RankingRequest;
import br.edu.infnet.projetodebloco.heroigen.response.RankingResponse;
import br.edu.infnet.projetodebloco.heroigen.service.CalculaRankingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/ranking")
public class RankingController {
	
	@Autowired
	CalculaRankingService calculaRankingService;
	
	@GetMapping(value = "/")
	public ResponseEntity<String> getRanking() {
		
		RankingResponse response = new RankingResponse();
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON).body(response.toString());
	}
	
	@PostMapping(value = "/salvaranking", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> gravarRanking(@Valid @RequestBody RankingRequest request) {

		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);
		
		log.info("\n\n A batalha a ser rankeada é:\n{}", request);
		
		if (!calculaRankingService.calculaRanking(request.getIdBatalha()))
			response = ResponseEntity.badRequest().contentType(MediaType.TEXT_PLAIN)
			.body("Batalha nao localizada ou nao encerrada");
			
//		response.
//		response.setDetails("Entrada no log registrada com sucesso");
		
		return response;
	}
}
