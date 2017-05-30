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
END