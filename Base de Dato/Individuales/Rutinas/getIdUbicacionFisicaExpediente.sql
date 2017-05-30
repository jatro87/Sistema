CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getIdUbicacionFisicaExpediente`(
	IN _descripcion VARCHAR (50),
    OUT _id INT
)
BEGIN

	SELECT id INTO _id FROM ubicaciones_expedientes WHERE descripcion = _descripcion LIMIT 1;

END