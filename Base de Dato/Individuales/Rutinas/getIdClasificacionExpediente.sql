CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getIdClasificacionExpediente`(
	IN _descripcion VARCHAR (50),
    OUT _id INT
)
BEGIN

	SELECT id INTO _id FROM clasificacion_expediente WHERE descripcion = _descripcion LIMIT 1;

END