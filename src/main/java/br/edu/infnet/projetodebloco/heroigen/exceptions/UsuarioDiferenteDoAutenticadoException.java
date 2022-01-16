package br.edu.infnet.projetodebloco.heroigen.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UsuarioDiferenteDoAutenticadoException extends Exception {

}
