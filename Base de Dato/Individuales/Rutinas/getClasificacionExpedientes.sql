CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getClasificacionExpedientes`()
BEGIN
	
    SELECT descripcion FROM clasificacion_expediente ORDER BY descripcion;
    
END