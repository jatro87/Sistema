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

END