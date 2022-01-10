package br.edu.infnet.projetodebloco.heroigen.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.edu.infnet.projetodebloco.heroigen.model.Turno;
import br.edu.infnet.projetodebloco.heroigen.response.LogTurnoBatalhaResponse;
import br.edu.infnet.projetodebloco.heroigen.service.LogService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	LogService logService;
	
	@GetMapping(value = "/batalhas/{idBatalha}")
	public ResponseEntity<String> getBatalha(@Valid @PathVariable("idBatalha") Integer idBatalha) {
		
		List<Turno> batalha = logService.getBatalha(idBatalha);
//		if(byId.isPresent()) {
//			model.addAttribute("autor", byId.get());
//		}
		
		log.info("Numero de turnos da batalha: {}",batalha.size());
		
		if (batalha.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Batalha não encontrada");
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON).body(batalha.toString());
	}
	
	@PostMapping(value = "/batalhas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> gravarTurnoBatalha(@Valid @RequestBody Turno logTurnoBatalhaRequest) {

		log.info("\n\n O turno a ser logado eh:\n{}", logTurnoBatalhaRequest);

		logService.salvar(logTurnoBatalhaRequest);
		
		return ResponseEntity.created(null)
				.contentType(MediaType.APPLICATION_JSON).body("Entrada no log registrada com sucesso");
	}
}
