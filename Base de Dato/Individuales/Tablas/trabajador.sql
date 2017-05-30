-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.10-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trabajador` (
  `no_ficha` varchar(15) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellidoP` varchar(30) NOT NULL,
  `apellidoM` varchar(30) NOT NULL,
  `domicilio_calle` varchar(30) NOT NULL,
  `domicilio_numero` varchar(20) NOT NULL,
  `domicilio_colonia` int(5) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `curp` varchar(18) NOT NULL,
  `rfc` varchar(13) NOT NULL,
  `clave_electoral` varchar(20) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  PRIMARY KEY (`no_ficha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'sistema'
--

--
-- Dumping routines for database 'sistema'
--
/*!50003 DROP PROCEDURE IF EXISTS `getClasificacionExpedientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getClasificacionExpedientes`()
BEGIN
	
    SELECT descripcion FROM clasificacion_expediente ORDER BY descripcion;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getColonia` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getColonia`(
	IN _nombre VARCHAR(45),
    OUT _id_colonia INT
)
BEGIN
	
    IF NOT EXISTS (SELECT colonias.id_colonia FROM colonias WHERE colonias.nombre REGEXP _nombre LIMIT 1) THEN
		
        INSERT INTO colonias (nombre) VALUES (_nombre);
        
	END IF;
        
	SELECT colonias.id_colonia INTO _id_colonia FROM colonias WHERE colonias.nombre REGEXP _nombre LIMIT 1;
        
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getConfiguracion` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getConfiguracion`(
	IN _descripcion VARCHAR (45)
)
BEGIN

	SELECT * FROM configuracion WHERE descripcion = _descripcion;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getExpediente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getExpediente`(
	IN _numero_expediente VARCHAR(15)
)
BEGIN

    SELECT  expedientes.nombre_documento,
			expedientes.fecha_registro,
			tipos_expedientes.descripcion,
            expedientes.descripcion,
            ubicaciones_expedientes.descripcion,
            clasificacion_expediente.descripcion
	FROM 	expedientes,
			tipos_expedientes,
            ubicaciones_expedientes,
            clasificacion_expediente
	WHERE 	expedientes.tipo = tipos_expedientes.id AND
			expedientes.id_expediente = _numero_expediente AND
            ubicaciones_expedientes.id = expedientes.ubicacion_fisica AND
            clasificacion_expediente.id = expedientes.clasificacion;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getIdClasificacionExpediente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getIdClasificacionExpediente`(
	IN _descripcion VARCHAR (50),
    OUT _id INT
)
BEGIN

	SELECT id INTO _id FROM clasificacion_expediente WHERE descripcion = _descripcion LIMIT 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getIdTipoExpediente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getIdTipoExpediente`(
	IN _descripcion VARCHAR (45),
    OUT _id INT
)
BEGIN
	
    SELECT id INTO _id FROM tipos_expedientes WHERE descripcion REGEXP _descripcion;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getIdUbicacionFisicaExpediente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getIdUbicacionFisicaExpediente`(
	IN _descripcion VARCHAR (50),
    OUT _id INT
)
BEGIN

	SELECT id INTO _id FROM ubicaciones_expedientes WHERE descripcion = _descripcion LIMIT 1;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getListaTiposExpedientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getListaTiposExpedientes`()
BEGIN

	SELECT descripcion FROM tipos_expedientes ORDER BY descripcion;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `getListaUbicacionesExpedientes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getListaUbicacionesExpedientes`()
BEGIN
	
    SELECT descripcion FROM ubicaciones_expedientes ORDER BY descripcion;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setClasificacionExpediente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `setClasificacionExpediente`(
	IN _clasificacion VARCHAR(45),
    OUT _mensaje VARCHAR(100)
)
BEGIN

	IF NOT EXISTS (SELECT id FROM clasificacion_expediente WHERE descripcion REGEXP _clasificacion) THEN
    
		INSERT INTO clasificacion_expediente (descripcion) VALUES (_clasificacion);
		SET _mensaje = "Clasificacion Registrada Exitosamente.";
        
	ELSE
    
		SET _mensaje = "La Clasificacion ya se Encuentra Registrada.";
        
	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setExpediente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `setExpediente`(
	IN _id_expediente VARCHAR (15),
    IN _tipo_expediente VARCHAR (45),
    IN _nombre_documento VARCHAR (100),
    IN _descripcion LONGTEXT,
    IN _clasificacion VARCHAR(45),
    IN _ubicacion_fisica VARCHAR(50),
    IN _identificador VARCHAR(100),
    OUT _mensaje VARCHAR (50)
)
BEGIN

	CALL getIdTipoExpediente(_tipo_expediente, @id_tipo_expediente);
	CALL getIdUbicacionFisicaExpediente(_ubicacion_fisica,@id_ubicacion);
    CALL getIdClasificacionExpediente(_clasificacion,@id_clasificacion);
    
	INSERT INTO expedientes (
						id_expediente,
                        tipo,
                        nombre_documento,
                        descripcion,
                        clasificacion,
                        ubicacion_fisica,
                        identificador)
				VALUES(
					_id_expediente,
                    @id_tipo_expediente,
                    _nombre_documento,
                    _descripcion,
                    @id_clasificacion,
                    @id_ubicacion,
                    _identificador);
				
    IF NOT EXISTS(SELECT descripcion FROM expedientes WHERE identificador = _identificador) THEN
		
        SET _mensaje = "Error: 0003, UUID Duplicado";
    
    ELSE
    
		SET _mensaje = "Expediente Registrado.";

	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setTipoExpediente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `setTipoExpediente`(
	IN _descripcion VARCHAR(45),
    OUT _mensaje VARCHAR(100)
)
BEGIN

	IF NOT EXISTS (SELECT id FROM tipos_expedientes WHERE descripcion REGEXP _descripcion) THEN
		
        INSERT INTO tipos_expedientes (descripcion) VALUES (_descripcion);
        
        SET _mensaje = "Tipo de Expediente Registrado.";
        
	ELSE
    
		SET _mensaje = "El Tipo de Expediente ya se Encuentra Registrado.";
        
	END IF;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setTrabajador` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `setTrabajador`(
	IN _no_ficha VARCHAR(15),
	IN _nombre VARCHAR(30),
    IN _apellidoP VARCHAR(30),
    IN _apellidoM VARCHAR(30),
    IN _domicilio_calle VARCHAR(30),
    IN _domicilio_numero VARCHAR(30),
    IN _domicilio_colonia VARCHAR(30),
    IN _telefono VARCHAR(15),
    IN _curp VARCHAR(18),
    IN _rfc VARCHAR(13),
    IN _clave VARCHAR(20),
    IN _fecha_nacimiento DATE,
    OUT _mensaje LONGTEXT
)
BEGIN

	DECLARE _id_colonia INT;

	IF EXISTS (SELECT descripcion FROM tipos_fichas WHERE tipos_fichas.id_ficha = SUBSTRING(_no_ficha,1,3)) THEN
    
		IF NOT EXISTS (SELECT no_ficha FROM trabajador WHERE no_ficha = _no_ficha) THEN
				
					CALL getColonia(_domicilio_colonia,@_id_colonia);
                
					INSERT INTO trabajador (no_ficha,
											nombre,
											apellidoP,
											apellidoM,
											domicilio_calle,
											domicilio_numero,
											domicilio_colonia,
											telefono,
											curp,
											rfc,
                                            clave_electoral,
                                            fecha_nacimiento)
											VALUES (_no_ficha,
													_nombre,
													_apellidoP,
													_apellidoM,
													_domicilio_calle,
													_domicilio_numero,
													@_id_colonia,
													_telefono,
													_curp,
													_rfc,
                                                    _clave,
                                                    _fecha_nacimiento);
                                                        
					SET _mensaje = 'Trabajador Registrado Correctamente.';
                                                        
		ELSE
														
			SET _mensaje = 'Error 0002: Registro Duplicado, Trabajador Ya Registrado';
        
        END IF;
        
	ELSE
		
        SET _mensaje = 'Error 0001: El Numero de Ficha No Pertenece a Ningun Tipo de Trabajador.';

	END IF;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `setUbicacionExpediente` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `setUbicacionExpediente`(
	IN _descripcion VARCHAR (50),	
    OUT _mensaje VARCHAR(100)
)
BEGIN

	IF NOT EXISTS (SELECT id FROM ubicaciones_expedientes WHERE descripcion REGEXP _descripcion) THEN
    
		INSERT INTO ubicaciones_expedientes (descripcion) VALUES (_descripcion);
		SET _mensaje = "Ubicacion Registrada Exitosamente.";
        
	ELSE
    
		SET _mensaje = "La Ubicacion ya se Encuentra Registrada.";
        
	END IF;
    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-26  9:20:23
