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
    SELECT * FROM gavetas;
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


-- Vistas
CREATE VIEW vista_envios AS
SELECT 
    e.id_envio,
    p.nombre_producto AS nombre_producto,
    e.id_gaveta,
    e.cantidad_en_kg,
    s.nombre AS nombre_supermercado,
    e.fecha
FROM envios e
JOIN productos p ON e.id_producto = p.id_producto
JOIN supermercados s ON e.id_supermercado = s.id_supermercado;

