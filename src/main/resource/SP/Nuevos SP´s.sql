-- Este procedimiento obtiene el ID de un estado de gaveta por su descripción.
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

-- Este procedimiento agrega una nueva gaveta con los parámetros proporcionados.
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

-- Este procedimiento obtiene todas las gavetas con información adicional del estado de la gaveta.
DELIMITER //
CREATE PROCEDURE ObtenerTodasLasGavetas()
BEGIN
    SELECT g.codigo_GA, g.color, g.tamanio, g.peso_maximo, g.es_propia, eg.descripcion as estado_descripcion
    FROM gavetas g
    INNER JOIN estados_gavetas eg ON g.id_estado = eg.id_estado;
END //
DELIMITER ;

-- Este procedimiento actualiza los datos de una gaveta existente.
DELIMITER //
CREATE PROCEDURE ActualizarGaveta(
    IN p_codigo_GA VARCHAR(10),
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
    WHERE codigo_GA = p_codigo_GA;
END //
DELIMITER ;
-- Proveedores
-- Agregar Proveedor
DELIMITER //

CREATE PROCEDURE AgregarProveedor(
    IN p_codigo_Provee VARCHAR(10),
    IN p_nombre_proveedor VARCHAR(100),
    IN p_telefono_proveedor VARCHAR(45),
    IN p_correo VARCHAR(45)
)
BEGIN
    INSERT INTO proveedores (codigo_Provee, nombre_proveedor, telefono_proveedor, correo)
    VALUES (p_codigo_Provee, p_nombre_proveedor, p_telefono_proveedor, p_correo);
END //

DELIMITER ;
-- Obtener todos los registros de provee
DELIMITER //

CREATE PROCEDURE ObtenerDatosProveedores()
BEGIN
    SELECT *
    FROM proveedores;
END //

DELIMITER ;

-- obtener id
DELIMITER //

create PROCEDURE ObtenerIdProveedorPorCodigo(
    IN p_codigo_Provee VARCHAR(40),
    OUT p_id_proveedor INT
)
BEGIN
    SELECT id_proveedor INTO p_id_proveedor
    FROM proveedores
    WHERE codigo_Provee = p_codigo_Provee;
END //

DELIMITER ;
-- Eliminar por id
DELIMITER //

CREATE PROCEDURE EliminarProveedor(
    IN p_id_proveedor INT
)
BEGIN
    DELETE FROM proveedores
    WHERE id_proveedor = p_id_proveedor;
END //

DELIMITER ;

-- Actualizar por id
DELIMITER //

CREATE PROCEDURE ActualizarProveedor(
    IN p_id_proveedor INT,
    IN p_nombre_proveedor VARCHAR(100),
    IN p_telefono_proveedor VARCHAR(45),
    IN p_correo VARCHAR(45)
)
BEGIN
    UPDATE proveedores
    SET 
        nombre_proveedor = p_nombre_proveedor,
        telefono_proveedor = p_telefono_proveedor,
        correo = p_correo
    WHERE id_proveedor = p_id_proveedor;
END //

DELIMITER ;
-- Productos
-- Agregar productos
DELIMITER //
CREATE PROCEDURE AgregarProducto(
    IN p_nombre_producto VARCHAR(100),
    IN p_id_proveedor INT
)
BEGIN
    INSERT INTO productos (nombre_producto, id_proveedor)
    VALUES (p_codigo_Product, p_nombre_producto, p_id_proveedor);
END //
DELIMITER ;
-- obtener registros
DELIMITER //
CREATE PROCEDURE ObtenerDatosProductos()
BEGIN
    SELECT p.id_producto, p.codigo_Product, p.nombre_producto, pr.nombre_proveedor
    FROM productos p
    JOIN proveedores pr ON p.id_proveedor = pr.id_proveedor;
END //
DELIMITER ;
-- Eliminar por id
DELIMITER //
CREATE PROCEDURE EliminarProductoPorID(
    IN p_id_producto INT
)
BEGIN
    DELETE FROM productos
    WHERE id_producto = p_id_producto;
END //
DELIMITER ;


-- obtener id
DELIMITER //
CREATE PROCEDURE ObtenerIdProductoPorCodigo(
    IN p_codigo_Product VARCHAR(10),
    OUT p_id_producto INT
)
BEGIN
    SELECT id_producto INTO p_id_producto
    FROM productos
    WHERE codigo_Product = p_codigo_Product;
END //
DELIMITER ;
-- obtener id proveedor por codigo producto
DELIMITER //
CREATE PROCEDURE ObtenerIdProveedorPorCodigoProducto(
    IN p_codigo_Product VARCHAR(10),
    OUT p_id_proveedor INT
)
BEGIN
    SELECT id_proveedor INTO p_id_proveedor
    FROM productos
    WHERE codigo_Product = p_codigo_Product;
END //
DELIMITER ;

-- actualizar
DELIMITER //
CREATE PROCEDURE ActualizarProducto(
    IN p_id_producto INT,
    IN p_nombre_producto VARCHAR(100),
    IN p_id_proveedor INT
)
BEGIN
    UPDATE productos
    SET 
        nombre_producto = p_nombre_producto,
        id_proveedor = p_id_proveedor
    WHERE id_producto = p_id_producto;
END //
DELIMITER ;
-- Entradas de inventario
-- Agregar
DELIMITER //

CREATE PROCEDURE agregarEntradaInven(
    IN p_id_proveedor INT,
    IN p_id_producto INT,
    IN p_cantidad_kg DECIMAL(10,2),
    IN p_fecha_entrada DATETIME
)
BEGIN
    INSERT INTO entradas_inventario (
        id_proveedor,
        id_producto,
        cantidad_kg,
        fecha_entrada
    ) VALUES (
        p_id_proveedor,
        p_id_producto,
        p_cantidad_kg,
        p_fecha_entrada
    );
END //

DELIMITER ;

-- Obtener
DELIMITER //

CREATE PROCEDURE obtenerEntradas()
BEGIN
    SELECT 
        ei.codigo_entrada,
        pr.nombre_proveedor AS proveedor,
        pd.nombre_producto AS producto,
        ei.cantidad_kg,
        ei.fecha_entrada
    FROM 
        entradas_inventario ei
        INNER JOIN proveedores pr ON ei.id_proveedor = pr.id_proveedor
        INNER JOIN productos pd ON ei.id_producto = pd.id_producto;
END //

DELIMITER ;

-- Obtener productos para el comboBox
DELIMITER //

CREATE PROCEDURE ObtenerListaNombresProd(
    IN p_id_proveedor INT
)
BEGIN
    SELECT 
        p.nombre_producto
    FROM productos p
    WHERE p.id_proveedor = p_id_proveedor;
END //

DELIMITER ;

-- obtener id de producto por su nombre
DELIMITER //

CREATE PROCEDURE ObtenerIdPorNombre(
    IN p_nombre_producto VARCHAR(100),
    OUT p_id_producto INT
)
BEGIN
    SELECT 
        id_producto
    INTO
        p_id_producto
    FROM productos
    WHERE nombre_producto = p_nombre_producto;
END //

DELIMITER ;
-- Supermercado
-- actualizar el supermercado
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `ActualizarSupermercado`(
    IN _id_supermercado INT,
    IN _nombre VARCHAR(100),
    IN _telefono VARCHAR(20),
    IN _encargado VARCHAR(45)
)
BEGIN
    UPDATE supermercados
    SET nombre = _nombre, 
        telefono = _telefono, 
        encargado = _encargado
    WHERE id_supermercado = _id_supermercado;
END

-- agregar un registro al tabla de super mercado
DELIMITER //

CREATE DEFINER=`root`@`localhost` PROCEDURE `AgregarSupermercado`(
    IN nombre VARCHAR(100),
    IN telefono VARCHAR(20),
    IN encargado VARCHAR(45)
)
BEGIN
    INSERT INTO supermercados (nombre, telefono, encargado) VALUES (nombre, telefono, encargado);
END //

DELIMITER ;

-- SP PARA OBTENER EL ID por codigo
DELIMITER //
CREATE PROCEDURE ObtenerIdSupermercadoPorCodigo(
    IN _codigoSuper VARCHAR(10),
    OUT _idSuper INT
)
BEGIN
    SELECT id_supermercado INTO _idSuper
    FROM supermercados
    WHERE codigo_Super = _codigoSuper
    LIMIT 1;
END //
DELIMITER ;

-- Envio general
-- sp para agregar un envio general
DELIMITER //
CREATE PROCEDURE `AgregarEnvioGeneral`(IN _id_supermercado INT)
BEGIN
    DECLARE _nuevo_codigoEnvioG VARCHAR(50);
    -- Genera el código de envío general. Ajusta esta lógica según sea necesario.
    SELECT CONCAT('EG', LPAD((SELECT COUNT(*) FROM envios_generales) + 1, 3, '0')) INTO _nuevo_codigoEnvioG;
    
    -- Inserta el nuevo registro en envios_generales con la fecha actual generada automáticamente.
    INSERT INTO envios_generales (codigoEnvioG, id_supermercado)
    VALUES (_nuevo_codigoEnvioG, _id_supermercado);
END

-- obtener el id por nombre
DELIMITER //
CREATE PROCEDURE ObtenerIdSupermercadoPorNombre(IN _nombre VARCHAR(100), OUT _idSupermercado INT)
BEGIN
    SELECT id_supermercado INTO _idSupermercado
    FROM supermercados
    WHERE nombre = _nombre
    LIMIT 1;
END //
DELIMITER ;

-- Envios
-- agregar un envio
DELIMITER //
CREATE PROCEDURE `AgregarEnvio`(
    IN _id_producto INT,
    IN _id_gaveta INT,
    IN _cantidad_en_kg DECIMAL(10,2),
    IN _id_envio_general INT
)
BEGIN
    INSERT INTO envios (id_producto, id_gaveta, cantidad_en_kg, id_envio_general)
    VALUES (_id_producto, _id_gaveta, _cantidad_en_kg, _id_envio_general);
END

-- vista para los envíos
DELIMITER //
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = 'root'@'localhost' 
    SQL SECURITY DEFINER
VIEW `vista_envios` AS
    SELECT 
        `e`.`id_envio` AS `id_envio`,
        `p`.`nombre_producto` AS `nombre_producto`,
        `g`.`codigo_GA` AS `codigo_gaveta`,
        `e`.`cantidad_en_kg` AS `cantidad_en_kg`,
        `eg`.`codigoEnvioG` AS `codigoEnvioG`,
        `s`.`nombre` AS `nombre_supermercado`
    FROM
        (((`envios` `e`
        JOIN `envios_generales` `eg` ON (`e`.`id_envio_general` = `eg`.`id_envio_general`))
        JOIN `productos` `p` ON (`e`.`id_producto` = `p`.`id_producto`))
        JOIN `gavetas` `g` ON (`e`.`id_gaveta` = `g`.`id`))
        JOIN `supermercados` `s` ON (`eg`.`id_supermercado` = `s`.`id_supermercado`);
DELIMITER;
-- este es la nueva vista
DELIMITER //
CREATE 
    ALGORITHM = UNDEFINED 
    DEFINER = 'root'@'localhost'  
    SQL SECURITY DEFINER
VIEW vista_envios AS
    SELECT 
        eg.`codigoEnvioG` AS codigoEnvioG,
        p.`nombre_producto` AS nombre_producto,
        g.`codigo_GA` AS codigo_gaveta,
        e.`cantidad_en_kg` AS cantidad_en_kg,
        e.`id_envio_general` AS id_envio_general,
        s.`nombre` AS nombre_supermercado
    FROM
        (((envios e
        JOIN envios_generales eg ON (e.`id_envio_general` = eg.`id_envio_general`))
        JOIN productos p ON (e.`id_producto` = p.`id_producto`))
        JOIN gavetas g ON (e.`id_gaveta` = g.`id`))
        JOIN supermercados s ON (eg.`id_supermercado` = s.`id_supermercado`));
DELIMITER ;
-- agrega envío general
DELIMITER //

create PROCEDURE AgregarEnvioGeneral(
    IN p_id_supermercado INT
)
BEGIN
    INSERT INTO envios_generales (id_supermercado, fecha)
    VALUES (p_id_supermercado, CURRENT_DATE);
END //

DELIMITER ;

-- Vistas
CREATE VIEW vista_envios AS
    SELECT 
        eg.codigoEnvioG,
        p.nombre_producto,
        g.codigo_GA,
        e.cantidad_en_kg,
        e.id_envio_general,
        s.nombre AS nombre_supermercado
    FROM
        envios e
        JOIN envios_generales eg ON e.id_envio_general = eg.id_envio_general
        JOIN productos p ON e.id_producto = p.id_producto
        JOIN gavetas g ON e.id_gaveta = g.id
        JOIN supermercados s ON eg.id_supermercado = s.id_supermercado;
-- Envios generales

CREATE VIEW vista_envios_generales AS
    SELECT 
        eg.codigoEnvioG,
        s.nombre AS nombre_supermercado,
        eg.fecha
    FROM
        envios_generales eg
        JOIN supermercados s ON eg.id_supermercado = s.id_supermercado;

-- EnviosREP
CREATE VIEW vista_enviosREP AS
SELECT 
    eg.codigoEnvioG,
    p.nombre_producto,
    g.codigo_GA,
    e.cantidad_en_kg,
    e.id_envio_general,
    s.nombre AS nombre_supermercado,
    CEIL(e.cantidad_en_kg / g.peso_maximo) AS numero_gavetas,
    eg.fecha
FROM envios e
JOIN envios_generales eg ON e.id_envio_general = eg.id_envio_general
JOIN productos p ON e.id_producto = p.id_producto
JOIN gavetas g ON e.id_gaveta = g.id
JOIN supermercados s ON eg.id_supermercado = s.id_supermercado;



