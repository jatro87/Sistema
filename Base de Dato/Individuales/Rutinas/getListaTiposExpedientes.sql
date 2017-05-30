CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getListaTiposExpedientes`()
BEGIN

	SELECT descripcion FROM tipos_expedientes ORDER BY descripcion;

END