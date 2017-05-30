CREATE DEFINER=`Sutsha`@`192.168.0.%` PROCEDURE `setTrabajador`(
	IN _no_ficha VARCHAR(15),
	IN _nombre VARCHAR(30),
    IN _apellidoP VARCHAR(30),
    IN _apellidoM VARCHAR(30),
    IN _domicilio_calle VARCHAR(30),
    IN _domicilio_numero VARCHAR(30),
    IN _domicilio_colonia VARCHAR(30),
    IN _telefono VARCHAR(15),
    IN _curp VARCHAR(18),
    IN _rfc VARCHAR(13),
    IN _clave VARCHAR(20),
    IN _fecha_nacimiento DATE,
    OUT _mensaje LONGTEXT
)
BEGIN

	DECLARE _id_colonia INT;

	IF EXISTS (SELECT descripcion FROM tipos_fichas WHERE tipos_fichas.id_ficha = SUBSTRING(_no_ficha,1,3)) THEN
    
		IF NOT EXISTS (SELECT no_ficha FROM trabajador WHERE no_ficha = _no_ficha) THEN
				
					CALL getColonia(_domicilio_colonia,@_id_colonia);
                
					INSERT INTO trabajador (no_ficha,
											nombre,
											apellidoP,
											apellidoM,
											domicilio_calle,
											domicilio_numero,
											domicilio_colonia,
											telefono,
											curp,
											rfc,
                                            clave_electoral,
                                            fecha_nacimiento)
											VALUES (_no_ficha,
													_nombre,
													_apellidoP,
													_apellidoM,
													_domicilio_calle,
													_domicilio_numero,
													@_id_colonia,
													_telefono,
													_curp,
													_rfc,
                                                    _clave,
                                                    _fecha_nacimiento);
                                                        
					SET _mensaje = 'Trabajador Registrado Correctamente.';
                                                        
		ELSE
														
			SET _mensaje = 'Error 0002: Registro Duplicado, Trabajador Ya Registrado';
        
        END IF;
        
	ELSE
		
        SET _mensaje = 'Error 0001: El Numero de Ficha No Pertenece a Ningun Tipo de Trabajador.';

	END IF;

END