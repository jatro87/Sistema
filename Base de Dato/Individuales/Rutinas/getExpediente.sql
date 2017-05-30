CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `getExpediente`(
	IN _numero_expediente VARCHAR(15)
)
BEGIN

    SELECT  expedientes.nombre_documento,
			expedientes.fecha_registro,
			tipos_expedientes.descripcion,
            expedientes.descripcion,
            ubicaciones_expedientes.descripcion,
            clasificacion_expediente.descripcion
	FROM 	expedientes,
			tipos_expedientes,
            ubicaciones_expedientes,
            clasificacion_expediente
	WHERE 	expedientes.tipo = tipos_expedientes.id AND
			expedientes.id_expediente = _numero_expediente AND
            ubicaciones_expedientes.id = expedientes.ubicacion_fisica AND
            clasificacion_expediente.id = expedientes.clasificacion;

END