-- Descrição da tabela HEROI: ID 	AGILIDADE  	DEFESA  	FORCA  	HEROI  	PONTOS_DE_VIDA  	QTD_DADOS_DANO  	TAMANHO_DADOS_DANO  
INSERT INTO `heroi` VALUES (1,3,3,4,'Guerreiro',12,2,4),(2,3,1,6,'Bárbaro',13,2,6),(3,1,5,2,'Paladino',15,2,4);

-- Descrição da tabela ITEM_LOG: ID DANO HEROI ID_BATALHA INICIATIVA MONSTRO USUARIO
-- Descrição da tabela TURNO: ID  ATACANTE  DANO        HEROI  BATALHA_ID MONSTRO USUARIO

-- Descrição da tabela TURNO: id, atacante, batalha_id, dano , heroi, monstro, usuario

INSERT INTO `turno` VALUES (1,0,1,3,'Guerreiro','Morto Vivo','Zombie Slayer');
INSERT INTO `turno` VALUES (2,1,1,2,'Guerreiro','Morto Vivo','Zombie Slayer');
INSERT INTO `turno` VALUES (3,0,1,5,'Guerreiro','Morto Vivo','Zombie Slayer');
INSERT INTO `turno` VALUES (4,0,2,4,'Bárbaro','Orc','Orc Killer');
INSERT INTO `turno` VALUES (5,0,3,7,'Paladino','Kobold','Bruninha Destruidora');
INSERT INTO `turno` VALUES (6,1,2,8,'Bárbaro','Orc','Orc Killer');

-- Descrição da tabela RANKING: ID BATALHA_ID PONTUACAO POSICAO USUARIO
INSERT INTO `ranking` VALUES (1,123456,56,1,'Bruninha Destruidora'),(2,654321,51,2,'Orc Killer'),(3,323111,50,3,'Zombie Slayer'),(4,555777,49,4,'Bruninha Destruidora');
