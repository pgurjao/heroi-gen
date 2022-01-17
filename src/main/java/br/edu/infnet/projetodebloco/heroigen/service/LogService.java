package br.edu.infnet.projetodebloco.heroigen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.projetodebloco.heroigen.model.Turno;
import br.edu.infnet.projetodebloco.heroigen.model.ItemRanking;
import br.edu.infnet.projetodebloco.heroigen.repository.LogRepository;
import lombok.Getter;

@Service
@Getter
public class LogService {

	private String errorMessage;
	
	@Autowired
	private LogRepository logRepository;
	
	public Turno salvar(Turno itemLog, ItemRanking ranking) {
		//Regras de Negócio
		itemLog.setRanking(ranking);
		return logRepository.save(itemLog);
	}
	
	public List<Turno> listAll(){
		return logRepository.findAllOrderByBatalhaIdAsc();
	}
	
	public List<Turno> getBatalha(Integer idBatalha, String nomeUsuario) {
		return logRepository.findBatalha(idBatalha, nomeUsuario);
	}
	
	public void delete(Integer id_ItemLog) {
		logRepository.deleteById(id_ItemLog);
	}
	
	public List<ItemRanking> obterRanking() {
		
		return null;
	}
	
//	public ItemLog salvar(ItemLog ItemLog) {
//		//Regras de Negócio
//		return logRepository.save(ItemLog);
//	}
	
//	public List<ItemLog> listAll(){
//		return logRepository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
//	}
	
//	public Optional<ItemLog> getById(Integer codigo_ItemLog) {
//		return logRepository.findById(codigo_ItemLog);
//	}
	
//	public void delete(Integer codigo_ItemLog) {
//		logRepository.deleteById(codigo_ItemLog);
//	}

}
