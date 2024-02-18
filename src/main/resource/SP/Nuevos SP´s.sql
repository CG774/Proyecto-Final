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
    IN p_codigo_Product VARCHAR(10),
    IN p_nombre_producto VARCHAR(100),
    IN p_id_proveedor INT
)
BEGIN
    INSERT INTO productos (codigo_Product, nombre_producto, id_proveedor)
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
