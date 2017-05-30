CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `setExpediente`(
	IN _id_expediente VARCHAR (15),
    IN _tipo_expediente VARCHAR (45),
    IN _nombre_documento VARCHAR (100),
    IN _descripcion LONGTEXT,
    IN _clasificacion VARCHAR(45),
    IN _ubicacion_fisica VARCHAR(50),
    IN _identificador VARCHAR(100),
    OUT _mensaje VARCHAR (50)
)
BEGIN

	CALL getIdTipoExpediente(_tipo_expediente, @id_tipo_expediente);
	CALL getIdUbicacionFisicaExpediente(_ubicacion_fisica,@id_ubicacion);
    CALL getIdClasificacionExpediente(_clasificacion,@id_clasificacion);
    
	INSERT INTO expedientes (
						id_expediente,
                        tipo,
                        nombre_documento,
                        descripcion,
                        clasificacion,
                        ubicacion_fisica,
                        identificador)
				VALUES(
					_id_expediente,
                    @id_tipo_expediente,
                    _nombre_documento,
                    _descripcion,
                    @id_clasificacion,
                    @id_ubicacion,
                    _identificador);
				
    IF NOT EXISTS(SELECT descripcion FROM expedientes WHERE identificador = _identificador) THEN
		
        SET _mensaje = "Error: 0003, UUID Duplicado";
    
    ELSE
    
		SET _mensaje = "Expediente Registrado.";

	END IF;
END