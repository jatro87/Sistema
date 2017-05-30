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
    
END