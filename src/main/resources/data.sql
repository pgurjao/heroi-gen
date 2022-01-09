-- Descrição da tabela HEROI: ID 	AGILIDADE  	DEFESA  	FORCA  	HEROI  	PONTOS_DE_VIDA  	QTD_DADOS_DANO  	TAMANHO_DADOS_DANO  
INSERT INTO `heroi` VALUES (1,3,3,4,'Guerreiro',12,2,4),(2,3,1,6,'Bárbaro',13,2,6),(3,1,5,2,'Paladino',15,2,4);

-- Descrição da tabela ITEM_LOG: ID DANO HEROI ID_BATALHA INICIATIVA MONSTRO USUARIO
-- Descrição da tabela ITEM_LOG: ID ATACANTE DANO HEROI ID_BATALHA MONSTRO USUARIO
INSERT INTO `turno` VALUES (1,0,3,'Guerreiro',1,'Morto Vivo','Zombie Slayer');
INSERT INTO `turno` VALUES (2,1,2,'Guerreiro',1,'Morto Vivo','Zombie Slayer');
INSERT INTO `turno` VALUES (3,0,5,'Guerreiro',1,'Morto Vivo','Zombie Slayer');
INSERT INTO `turno` VALUES (4,0,4,'Bárbaro',2,'Orc','Orc Killer');
INSERT INTO `turno` VALUES (5,0,7,'Paladino',3,'Kobold','Bruninha Destruidora');
INSERT INTO `turno` VALUES (6,1,8,'Bárbaro',2,'Orc','Orc Killer');

-- Descrição da tabela ITEM_RANKING: ID ID_BATALHA PONTUACAO POSICAO USUARIO
INSERT INTO `batalha` VALUES (1,123456,56,1,'Bruninha Destruidora'),(2,654321,51,2,'Orc Killer'),(3,323111,50,3,'Zombie Slayer'),(4,555777,49,4,'Bruninha Destruidora');
