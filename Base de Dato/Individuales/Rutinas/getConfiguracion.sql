CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getConfiguracion`(
	IN _descripcion VARCHAR (45)
)
BEGIN

	SELECT * FROM configuracion WHERE descripcion = _descripcion;
    
END