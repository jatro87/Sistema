CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getListaUbicacionesExpedientes`()
BEGIN
	
    SELECT descripcion FROM ubicaciones_expedientes ORDER BY descripcion;

END