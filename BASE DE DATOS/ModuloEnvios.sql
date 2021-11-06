CREATE SCHEMA `analisissistemas2`;

CREATE TABLE `productos` (
  `id_Producto` bigint NOT NULL AUTO_INCREMENT,
  `descripcion_producto` varchar(60) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `cantidad_stock` bigint DEFAULT NULL,
  PRIMARY KEY (`id_Producto`)
);

CREATE TABLE `pesos` (
  `idpesos` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idpesos`)
)

CREATE TABLE `bitacora_det_ped_envio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_pedido` bigint DEFAULT NULL,
  `id_producto` bigint DEFAULT NULL,
  `id_envio` bigint DEFAULT NULL,
  `cantidad_enviada` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `clientes` (
  `id_cliente` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_cliente`)
);
CREATE TABLE `dimensiones` (
  `id_dimensiones` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_dimensiones`)
)
CREATE TABLE `pedidos` (
  `idpedido` bigint NOT NULL AUTO_INCREMENT,
  `fecha_pedido` date DEFAULT NULL,
  `status_pedido` varchar(20) DEFAULT NULL,
  `id_cliente` bigint DEFAULT NULL,
  PRIMARY KEY (`idpedido`),
  KEY `FK9y4jnyp1hxqa386cnly0ay9uw` (`id_cliente`),
  CONSTRAINT `FK9y4jnyp1hxqa386cnly0ay9uw` FOREIGN KEY (`id_cliente`) REFERENCES `clientes` (`id_cliente`)
);

CREATE TABLE `detalle_pedidos` (
  `id_pedido` bigint NOT NULL,
  `id_producto` bigint NOT NULL,
  `cantidad_enviada` bigint DEFAULT NULL,
  `cantidad_pedida` bigint DEFAULT NULL,
  PRIMARY KEY (`id_pedido`,`id_producto`),
  KEY `FK55ne0fk3mr6bj6ulepye12kar` (`id_producto`),
  CONSTRAINT `FK1h34af0hyh8r841nru9x8jpnv` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`idpedido`),
  CONSTRAINT `FK55ne0fk3mr6bj6ulepye12kar` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_Producto`)
);

CREATE TABLE `envios` (
  `idenvio` bigint NOT NULL AUTO_INCREMENT,
  `estado` varchar(20) DEFAULT NULL,
  `alto` bigint DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `fecha_entrega` date DEFAULT NULL,
  `fondo` bigint DEFAULT NULL,
  `largo` bigint DEFAULT NULL,
  `metodo_envio` varchar(45) DEFAULT NULL,
  `nota` varchar(150) DEFAULT NULL,
  `numero_seguimiento` bigint DEFAULT NULL,
  `pdf` tinyblob,
  `peso` bigint DEFAULT NULL,
  `tipo_dimension` bigint DEFAULT NULL,
  `id_pedido` bigint DEFAULT NULL,
  `tipo_peso` bigint DEFAULT NULL,
  PRIMARY KEY (`idenvio`),
  KEY `FKbtyix65l2oj87bmt664fgciju` (`tipo_dimension`),
  KEY `FK9gly31a8osechlg4s23sfdih5` (`id_pedido`),
  KEY `FKdfi1iiur55h6x63hdbogngho5` (`tipo_peso`),
  CONSTRAINT `FK9gly31a8osechlg4s23sfdih5` FOREIGN KEY (`id_pedido`) REFERENCES `pedidos` (`idpedido`),
  CONSTRAINT `FKbtyix65l2oj87bmt664fgciju` FOREIGN KEY (`tipo_dimension`) REFERENCES `dimensiones` (`id_dimensiones`),
  CONSTRAINT `FKdfi1iiur55h6x63hdbogngho5` FOREIGN KEY (`tipo_peso`) REFERENCES `pesos` (`idpesos`)
);

INSERT INTO `detalle_pedidos` VALUES (1,1,0,1);
INSERT INTO `detalle_pedidos` VALUES (1,2,0,2);
INSERT INTO `detalle_pedidos` VALUES (2,1,0,2);
INSERT INTO `clientes` VALUES (1,'juan@maill.com','Juan Garcia','A','43242384');
INSERT INTO `clientes` VALUES (2,'pedro@mail.com','Pedro Lopez','A','12312936');


INSERT INTO `productos` VALUES (1,'Computadora Dell',4500,89);
INSERT INTO `productos` VALUES (2,'Monitor HP 24 pul',1500,96);
INSERT INTO `productos` VALUES (3,'Computadora HP',3750,90);


INSERT INTO `pedidos` VALUES (1,'2021-10-13','Confirmado',1);
INSERT INTO `pedidos` VALUES (2,'2021-10-15','Confirmado',2);

INSERT INTO `dimensiones` (`id_dimensiones`,`descripcion`) VALUES (1,'m');
INSERT INTO `dimensiones` (`id_dimensiones`,`descripcion`) VALUES (2,'dm');
INSERT INTO `dimensiones` (`id_dimensiones`,`descripcion`) VALUES (3,'cm');
INSERT INTO `dimensiones` (`id_dimensiones`,`descripcion`) VALUES (4,'mm');
INSERT INTO `dimensiones` (`id_dimensiones`,`descripcion`) VALUES (5,'pie');
INSERT INTO `dimensiones` (`id_dimensiones`,`descripcion`) VALUES (6,'pulgada');


INSERT INTO `pesos` (`idpesos`,`descripcion`) VALUES (1,'tonelada');
INSERT INTO `pesos` (`idpesos`,`descripcion`) VALUES (2,'kg');
INSERT INTO `pesos` (`idpesos`,`descripcion`) VALUES (3,'g');
INSERT INTO `pesos` (`idpesos`,`descripcion`) VALUES (4,'mg');
INSERT INTO `pesos` (`idpesos`,`descripcion`) VALUES (5,'onza');
INSERT INTO `pesos` (`idpesos`,`descripcion`) VALUES (6,'libra');
