package br.edu.infnet.projetodebloco.heroigen.controller;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.projetodebloco.heroigen.request.LogTurnoBatalhaRequest;
import br.edu.infnet.projetodebloco.heroigen.response.LogTurnoBatalhaResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/log")
public class LogController {
	
	@PostMapping(value = "/salvalog", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LogTurnoBatalhaResponse> gravarTurnoBatalha(@Valid @RequestBody LogTurnoBatalhaRequest logTurnoBatalhaRequest) {

		log.info("\n\n O turno a ser logado eh:\n{}", logTurnoBatalhaRequest);
		
		LogTurnoBatalhaResponse response = new LogTurnoBatalhaResponse(
//				logTurnoBatalha.getIdBatalha(),
//				logTurnoBatalha.getUsuario(),
//				logTurnoBatalha.getHeroi(),
//				logTurnoBatalha.getMonstro(),
//				logTurnoBatalha.getIniciativa(),
//				logTurnoBatalha.getDano(),
				null,
				null,
				null);
		
		response.setStatus(HttpStatus.OK.value());
		response.setDetails("Entrada no log registrada com sucesso");
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON).body(response);
	}
}
