INSERT INTO `heroku_a8545ef9b302441`.`finca` (`fecha`, `idfinca`, `superf`, `denom`, `direccion`, `ref`) VALUES ('2023-02-22', '1', '200', 'terrace', 'C/moto', '342R');
INSERT INTO `heroku_a8545ef9b302441`.`finca` (`fecha`, `idfinca`, `superf`, `denom`, `direccion`, `ref`) VALUES ('2023-05-11', '2', '160', 'cereene', 'C/mariano', '265F');
INSERT INTO `heroku_a8545ef9b302441`.`finca` (`fecha`, `idfinca`, `superf`, `denom`, `direccion`, `ref`) VALUES ('2022-07-29', '3', '290', 'afinconar', 'C/monaco', '273L');


INSERT INTO `heroku_a8545ef9b302441`.`variedad` (`idvariedad`, `color`, `nombre`) VALUES ('1', 'red', 'meana');
INSERT INTO `heroku_a8545ef9b302441`.`variedad` (`idvariedad`, `color`, `nombre`) VALUES ('2', 'green', 'clara');


INSERT INTO `heroku_a8545ef9b302441`.`arbol` (`columna`, `fecha`, `fila`, `finca_idfinca`, `idarbol`, `idvariedad`, `estado`) VALUES ('4', '2023-09-01', '4', '1', '1', '1', 'sano');
INSERT INTO `heroku_a8545ef9b302441`.`arbol` (`columna`, `fecha`, `fila`, `finca_idfinca`, `idarbol`, `idvariedad`, `estado`) VALUES ('2', '2023-09-01', '12', '2', '2', '1', 'sano');
INSERT INTO `heroku_a8545ef9b302441`.`arbol` (`columna`, `fecha`, `fila`, `finca_idfinca`, `idarbol`, `idvariedad`, `estado`) VALUES ('3', '2023-09-01', '7', '3', '3', '1', 'sano');


INSERT INTO `heroku_a8545ef9b302441`.`roles` (`nombre`) VALUES ('ROLE_ADMIN');
INSERT INTO `heroku_a8545ef9b302441`.`roles` (`nombre`) VALUES ('ROLE_USER');

INSERT INTO `heroku_a8545ef9b302441`.`usuarios` (`password`, `username`) VALUES ('$2a$10$YvOkNMifMEcNsXRvR4mq5ehUHbG2Cj5uJpOEUaj/r.pezhMB5O5L6', 'admin');
INSERT INTO `heroku_a8545ef9b302441`.`usuarios` (`password`, `username`) VALUES ('$2a$10$YvOkNMifMEcNsXRvR4mq5ehUHbG2Cj5uJpOEUaj/r.pezhMB5O5L6', 'user');

INSERT INTO `heroku_a8545ef9b302441`.`usuariorol` (`idrol`, `idusuario`) VALUES ('1', '1');
INSERT INTO `heroku_a8545ef9b302441`.`usuariorol` (`idrol`, `idusuario`) VALUES ('11', '11');

INSERT INTO `heroku_a8545ef9b302441`.`tratamiento` (`idtratamiento`, `fecha`, `nombre`) VALUES ('1', '2023-04-29', 'fungicida');
INSERT INTO `heroku_a8545ef9b302441`.`tratamiento` (`idtratamiento`, `fecha`, `nombre`) VALUES ('2', '2023-04-29', 'insecticida');
INSERT INTO `heroku_a8545ef9b302441`.`tratamiento` (`idtratamiento`, `fecha`, `nombre`) VALUES ('3', '2023-05-16', 'fertilizante');

INSERT INTO `heroku_a8545ef9b302441`.`recoleccion` (`idrecoleccion`, `fecha`, `kilos`, `idfinca`, `idvariedad`) VALUES ('1', '2023-05-21', '105', '1', '1');
INSERT INTO `heroku_a8545ef9b302441`.`recoleccion` (`idrecoleccion`, `fecha`, `kilos`, `idfinca`, `idvariedad`) VALUES ('2', '2023-05-25', '190', '2', '2');





