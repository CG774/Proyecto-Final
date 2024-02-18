DELIMITER //

CREATE PROCEDURE ObtenerIdEstadoPorDescripcion(
    IN p_descripcion VARCHAR(50),
    OUT p_id_estado INT
)
BEGIN
    SELECT id_estado INTO p_id_estado
    FROM estados_gavetas
    WHERE descripcion = p_descripcion;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE AgregarGaveta(
    IN p_color VARCHAR(50),
    IN p_tamanio VARCHAR(50),
    IN p_peso_maximo DECIMAL(10,2),
    IN p_es_propia ENUM('SI','NO'),
    IN p_id_estado INT
)
BEGIN
    INSERT INTO gavetas (color, tamanio, peso_maximo, es_propia, id_estado)
    VALUES (p_color, p_tamanio, p_peso_maximo, p_es_propia, p_id_estado);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE ObtenerTodasLasGavetas()
BEGIN
    SELECT g.id, g.color, g.tamanio, g.peso_maximo, g.es_propia, eg.descripcion as estado_descripcion
    FROM gavetas g
    INNER JOIN estados_gavetas eg ON g.id_estado = eg.id_estado;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE ActualizarGaveta(
    IN p_id INT,
    IN p_color VARCHAR(50),
    IN p_tamanio VARCHAR(50),
    IN p_peso_maximo DECIMAL(10,2),
    IN p_es_propia ENUM('SI','NO'),
    IN p_id_estado INT
)
BEGIN
    UPDATE gavetas
    SET
        color = p_color,
        tamanio = p_tamanio,
        peso_maximo = p_peso_maximo,
        es_propia = p_es_propia,
        id_estado = p_id_estado
    WHERE id = p_id;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE AgregarSupermercado(
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20)
)
BEGIN
    INSERT INTO supermercados (nombre, telefono)
    VALUES (p_nombre, p_telefono);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE ObtenerSupermercados()
BEGIN
    SELECT * FROM supermercados;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE ActualizarSupermercado(
    IN p_id_supermercado INT,
    IN p_nombre VARCHAR(100),
    IN p_telefono VARCHAR(20)
)
BEGIN
    UPDATE supermercados
    SET
        nombre = p_nombre,
        telefono = p_telefono
    WHERE id_supermercado = p_id_supermercado;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE AgregarEnvioGeneral(
    IN p_id_supermercado INT,
    IN p_fecha DATE
)
BEGIN
    INSERT INTO envios_generales (id_supermercado, fecha)
    VALUES (p_id_supermercado, p_fecha);
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE ObtenerEnviosGenerales()
BEGIN
    SELECT eg.id_envio_general, s.nombre AS nombre_supermercado, eg.fecha
    FROM envios_generales eg
    INNER JOIN supermercados s ON eg.id_supermercado = s.id_supermercado;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE ObtenerIdSupermercadoPorNombre(
    IN p_nombre_supermercado VARCHAR(100),
    OUT p_id_supermercado INT
)
BEGIN
    SELECT id_supermercado INTO p_id_supermercado
    FROM supermercados
    WHERE nombre = p_nombre_supermercado
    LIMIT 1;
END //

DELIMITER ;
-- SPS de reporte
DELIMITER //
CREATE PROCEDURE ObtenerDatosVistaEnvio()
BEGIN
    SELECT * FROM vista_envios;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE ObtenerDatosVistaEntrada()
BEGIN
    SELECT * FROM vista_entradas_inventario;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE FiltrarEntradasPorFecha(IN seleccion VARCHAR(10))
BEGIN
    DECLARE fechaActual DATETIME;
    SET fechaActual = NOW();
    
    IF seleccion = 'Día' THEN
        SELECT * FROM vista_entradas_inventario WHERE DATE(FechaEntrada) = DATE(fechaActual);
    ELSEIF seleccion = 'Semana' THEN
        SELECT * FROM vista_entradas_inventario WHERE YEARWEEK(FechaEntrada) = YEARWEEK(fechaActual);
    ELSEIF seleccion = 'Mes' THEN
        SELECT * FROM vista_entradas_inventario WHERE YEAR(FechaEntrada) = YEAR(fechaActual) AND MONTH(FechaEntrada) = MONTH(fechaActual);
    END IF;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE FiltrarEnviosPorFecha(IN seleccion VARCHAR(10))
BEGIN
    DECLARE fechaActual DATETIME;
    SET fechaActual = NOW();
    
    IF seleccion = 'Día' THEN
        SELECT * FROM vista_envios WHERE DATE(fecha) = DATE(fechaActual);
    ELSEIF seleccion = 'Semana' THEN
        SELECT * FROM vista_envios WHERE YEARWEEK(fecha) = YEARWEEK(fechaActual);
    ELSEIF seleccion = 'Mes' THEN
        SELECT * FROM vista_envios WHERE YEAR(fecha) = YEAR(fechaActual) AND MONTH(fecha) = MONTH(fechaActual);
    END IF;
END//
DELIMITER ;


-- Vistas
CREATE VIEW vista_envios AS
SELECT
    e.id_envio,
    e.id_gaveta,
    p.nombre_producto,
    CEIL(e.cantidad_en_kg / g.peso_maximo) AS numero_gavetas,
    e.cantidad_en_kg,
    s.nombre AS nombre_supermercado,
    eg.fecha
FROM envios e
JOIN productos p ON e.id_producto = p.id_producto
JOIN envios_generales eg ON e.id_envio_general = eg.id_envio_general
JOIN gavetas g ON e.id_gaveta = g.id
JOIN supermercados s ON eg.id_supermercado = s.id_supermercado;



