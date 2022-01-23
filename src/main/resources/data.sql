-- Descrição da tabela HEROI: ID 	AGILIDADE  	DEFESA  	FORCA  	HEROI	PONTOS_DE_VIDA  	QTD_DADOS_DANO  	TAMANHO_DADOS_DANO  
INSERT INTO `heroi` VALUES 		(1,3,3,4,'Guerreiro',12,2,4)
							,	(2,3,1,6,'Bárbaro',	 13,2,6)
							,	(3,1,5,2,'Paladino', 15,2,4);

-- Descrição da tabela ITEM_LOG: ID DANO HEROI ID_BATALHA INICIATIVA MONSTRO USUARIO
-- Descrição da tabela TURNO: ID  ATACANTE  DANO        HEROI  BATALHA_ID MONSTRO USUARIO

-- Descrição da tabela RANKING: ID BATALHA_ID PONTUACAO POSICAO USUARIO
INSERT INTO `ranking` VALUES (1,56,'Bruninha Destruidora')
							,(2,51,'Orc Killer')
							,(3,50,'Zombie Slayer');
							
							
-- Descrição da tabela TURNO: id, atacante, batalha_id, dano , heroi, monstro, usuario
INSERT INTO `turno`(id, atacante, batalha_id, dano, heroi, monstro, usuario) VALUES (1,0,323111,3,'Guerreiro','Morto Vivo','Zombie Slayer');
INSERT INTO `turno`(id, atacante, batalha_id, dano, heroi, monstro, usuario) VALUES (2,1,323111,2,'Guerreiro','Morto Vivo','Zombie Slayer');
INSERT INTO `turno`(id, atacante, batalha_id, dano, heroi, monstro, usuario) VALUES (3,0,323111,5,'Guerreiro','Morto Vivo','Zombie Slayer');
INSERT INTO `turno`(id, atacante, batalha_id, dano, heroi, monstro, usuario) VALUES (4,0,654321,4,'Bárbaro','Orc','Orc Killer');
INSERT INTO `turno`(id, atacante, batalha_id, dano, heroi, monstro, usuario) VALUES (5,0,555777,7,'Paladino','Kobold','Bruninha Destruidora');
INSERT INTO `turno`(id, atacante, batalha_id, dano, heroi, monstro, usuario) VALUES (6,1,654321,8,'Bárbaro','Orc','Orc Killer');

