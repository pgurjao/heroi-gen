package br.edu.infnet.projetodebloco.heroigen.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.projetodebloco.heroigen.model.Heroi;
import br.edu.infnet.projetodebloco.heroigen.service.HeroiService;

@Validated
@RestController
@RequestMapping("/heroi-gen")
public class HeroiController {

	@Autowired
	HeroiService heroiService;
	
	@GetMapping(value = "/herois")
	public ResponseEntity<String> listarHerois() {

		List<Heroi> heroi = heroiService.findAll();
		
		if (heroi.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.TEXT_PLAIN)
					.body("Nenhum herói cadastrado");

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
				.body(heroi.toString());
	}
	
	@GetMapping(value = "/herois/{idHeroi}")
	public ResponseEntity<String> getHeroi(@Valid @PathVariable("idHeroi") Integer idHeroi) {

		Optional<Heroi> heroi = heroiService.getById(idHeroi);
		
		if(heroi.isPresent()) {
			Heroi heroiRetorno = new Heroi();
			heroiRetorno = heroi.get();
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
					.body(heroiRetorno.toString());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.contentType(MediaType.TEXT_PLAIN).body("Heroi não encontrado!");
	}
}
