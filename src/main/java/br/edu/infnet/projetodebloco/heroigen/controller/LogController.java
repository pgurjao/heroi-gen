package br.edu.infnet.projetodebloco.heroigen.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.projetodebloco.heroigen.dtos.UsuarioAutenticado;
import br.edu.infnet.projetodebloco.heroigen.exceptions.UsuarioDiferenteDoAutenticadoException;
import br.edu.infnet.projetodebloco.heroigen.model.ItemRanking;
import br.edu.infnet.projetodebloco.heroigen.model.Turno;
import br.edu.infnet.projetodebloco.heroigen.response.LogTurnoBatalhaResponse;
import br.edu.infnet.projetodebloco.heroigen.service.LogService;
import br.edu.infnet.projetodebloco.heroigen.service.RankingService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	LogService logService;
	
	@Autowired
	private RankingService rankingService;
	
	@GetMapping(value = "/batalhas/{idBatalha}")
	public ResponseEntity<String> getBatalha(
			@Valid @PathVariable("idBatalha") Integer idBatalha
			, Authentication auth) {
		
		UsuarioAutenticado usuarioAutenticado = (UsuarioAutenticado) auth.getPrincipal();
		
		List<Turno> batalha = logService.getBatalha(idBatalha, usuarioAutenticado.getUsername() );
		
		log.info("Numero de turnos da batalha: {}",batalha.size());
		
		if (batalha.size() == 0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.contentType(MediaType.TEXT_PLAIN).body("Batalha não encontrada");
		
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON).body(batalha.toString());
	}
	
	@PostMapping(value = "/batalhas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> gravarTurnoBatalha(@Valid @RequestBody 	Turno logTurnoBatalhaRequest
																		, 	Authentication auth) throws Exception {

		log.info("\n\n O turno a ser logado eh:\n{}", logTurnoBatalhaRequest);

		final UsuarioAutenticado usuario = (UsuarioAutenticado) auth.getPrincipal();
		
		final String nomeUsuarioLogado = usuario.getUsername();
		
		ItemRanking ranking = this.rankingService.getRanking(logTurnoBatalhaRequest.getBatalhaId());
		
		if( !nomeUsuarioLogado.equals( logTurnoBatalhaRequest.getUsuario() ) ) 
		{
			throw new UsuarioDiferenteDoAutenticadoException();			
		}
		
		if( !nomeUsuarioLogado.equals( ranking.getUsuario() ) ) 
		{
			throw new UsuarioDiferenteDoAutenticadoException();			
		}
		
		logService.salvar(logTurnoBatalhaRequest, ranking);
		
		return ResponseEntity.created(null)
				.contentType(MediaType.APPLICATION_JSON).body("Entrada no log registrada com sucesso");
		
		
	}
}
