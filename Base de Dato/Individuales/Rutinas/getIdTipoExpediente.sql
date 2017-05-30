CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getIdTipoExpediente`(
	IN _descripcion VARCHAR (45),
    OUT _id INT
)
BEGIN
	
    SELECT id INTO _id FROM tipos_expedientes WHERE descripcion REGEXP _descripcion;

END