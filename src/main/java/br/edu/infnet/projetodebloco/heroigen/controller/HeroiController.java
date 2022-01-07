package br.edu.infnet.projetodebloco.heroigen.controller;

import java.security.SecureRandom;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.projetodebloco.heroigen.model.Heroi;
import br.edu.infnet.projetodebloco.heroigen.model.HeroisEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/heroi-gen")
public class HeroiController {

	@GetMapping(value = "/herois")
	public ResponseEntity<String> gerarHerois() {

		ResponseEntity<String> response = new ResponseEntity<String>(HttpStatus.OK);

		SecureRandom secureRandom = new SecureRandom();
		// 0 to 3 inclusive.
		int randomInteger = secureRandom.nextInt(3);

		HeroisEnum heroisEnum = HeroisEnum.values()[randomInteger];
		Heroi heroi = new Heroi();

		switch (heroisEnum) {
		case GUERREIRO:
			heroi.setHeroi(heroisEnum);
			heroi.setPontosDeVida(12);
			heroi.setForca(4);
			heroi.setDefesa(3);
			heroi.setAgilidade(3);
			heroi.setQtdDadosDano(2);
			heroi.setTamanhoDadosDano(4);
			break;
		case BARBARO:
			heroi.setHeroi(heroisEnum);
			heroi.setPontosDeVida(13);
			heroi.setForca(6);
			heroi.setDefesa(1);
			heroi.setAgilidade(3);
			heroi.setQtdDadosDano(2);
			heroi.setTamanhoDadosDano(6);
			break;
		case PALADINO:
			heroi.setHeroi(heroisEnum);
			heroi.setPontosDeVida(15);
			heroi.setForca(2);
			heroi.setDefesa(5);
			heroi.setAgilidade(1);
			heroi.setQtdDadosDano(2);
			heroi.setTamanhoDadosDano(4);
			break;

		default:
			response = ResponseEntity.internalServerError().contentType(MediaType.TEXT_PLAIN)
					.body("Erro ao setar atributos do heroi");
			break;
		}

		if (response.getStatusCode() != HttpStatus.OK)
			return response;

		log.info("\n\n Numero aleatorio gerado: {}\n\n Heroi gerado:\n{}",randomInteger, heroi);
		
		return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN)
				.body(heroi.toString());
	}
}
