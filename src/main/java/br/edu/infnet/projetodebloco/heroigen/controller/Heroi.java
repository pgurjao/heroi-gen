package br.edu.infnet.projetodebloco.heroigen.controller;

import java.security.SecureRandom;
import java.util.Random;


import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/heroi-gen")
public class Heroi {
	
	@GetMapping(value = "/herois")
	public ResponseEntity<String> gerarHerois() {

		Random rand = new SecureRandom();
		
		//0 to 100 inclusive.
		int number = rand.nextInt(3);
		
		String retorno = String.valueOf(number);

		log.info("\n\n O numero gerado foi: {}", number);

		return ResponseEntity.ok()
//				.header(retorno, null)
				.contentType(MediaType.TEXT_PLAIN).body(retorno);
		
	}
}
