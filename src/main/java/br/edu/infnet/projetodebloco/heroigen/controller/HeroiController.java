package br.edu.infnet.projetodebloco.heroigen.controller;

import java.security.SecureRandom;
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

import br.edu.infnet.projetodebloco.heroigen.enums.HeroisEnum;
import br.edu.infnet.projetodebloco.heroigen.model.Heroi;
import br.edu.infnet.projetodebloco.heroigen.service.HeroiService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/heroi-gen")
public class HeroiController {

	@Autowired
	HeroiService heroiService;
	
	@GetMapping(value = "/herois/all")
	public ResponseEntity<String> gerarHeroi() {

		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);

//		SecureRandom secureRandom = new SecureRandom();
		// 0 to 3 inclusive.
//		int randomInteger = secureRandom.nextInt(3);
//
//		HeroisEnum heroisEnum = HeroisEnum.values()[randomInteger];
//		
//		Heroi heroi = new Heroi();

//		switch (heroisEnum) {
//		case GUERREIRO:
//			heroi.setHeroi(heroisEnum);
//			heroi.setPontosDeVida(12);
//			heroi.setForca(4);
//			heroi.setDefesa(3);
//			heroi.setAgilidade(3);
//			heroi.setQtdDadosDano(2);
//			heroi.setTamanhoDadosDano(4);
//			break;
//		case BARBARO:
//			heroi.setHeroi(heroisEnum);
//			heroi.setPontosDeVida(13);
//			heroi.setForca(6);
//			heroi.setDefesa(1);
//			heroi.setAgilidade(3);
//			heroi.setQtdDadosDano(2);
//			heroi.setTamanhoDadosDano(6);
//			break;
//		case PALADINO:
//			heroi.setHeroi(heroisEnum);
//			heroi.setPontosDeVida(15);
//			heroi.setForca(2);
//			heroi.setDefesa(5);
//			heroi.setAgilidade(1);
//			heroi.setQtdDadosDano(2);
//			heroi.setTamanhoDadosDano(4);
//			break;
//
//		default:
//			response = ResponseEntity.internalServerError().contentType(MediaType.TEXT_PLAIN)
//					.body("Erro ao setar atributos do heroi");
//			break;
//		}

//		if (response.getStatusCode() != HttpStatus.OK)
//			return response;
		
		List<Heroi> heroi = heroiService.findAll();

//		log.info("Numero de HeroisEnum: {}",heroisEnum.ordinal());
//		
//		log.info("\n\n Numero aleatorio gerado: {}\n\n Heroi gerado:\n{}",randomInteger, heroi);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
				.body(heroi.toString());
	}
	
	@GetMapping(value = "/herois/{idHeroi}")
	public ResponseEntity<String> getHeroi(@Valid @PathVariable("idHeroi") Integer idHeroi) {

		HeroisEnum heroiEnum;
		
		try {
			heroiEnum = HeroisEnum.values()[idHeroi];
		} catch (ArrayIndexOutOfBoundsException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Tipo Herói não existe!");
		}
		
		Optional<Heroi> heroi = heroiService.getByHeroi(heroiEnum);
		
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
