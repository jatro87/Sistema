CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getColonia`(
	IN _nombre VARCHAR(45),
    OUT _id_colonia INT
)
BEGIN
	
    IF NOT EXISTS (SELECT colonias.id_colonia FROM colonias WHERE colonias.nombre REGEXP _nombre LIMIT 1) THEN
		
        INSERT INTO colonias (nombre) VALUES (_nombre);
        
	END IF;
        
	SELECT colonias.id_colonia INTO _id_colonia FROM colonias WHERE colonias.nombre REGEXP _nombre LIMIT 1;
        
END