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
