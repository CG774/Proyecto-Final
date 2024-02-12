<<<<<<< HEAD
-- Agrega un producto a la tabla de productos
DELIMITER //
=======
DELIMITER //

>>>>>>> Carlos_Branch
CREATE PROCEDURE AgregarProducto(
    IN nombre_producto VARCHAR(255)
)
BEGIN
    INSERT INTO productos (nombre_producto) VALUES (nombre_producto);
END //
<<<<<<< HEAD
DELIMITER ;

-- Obtiene todos los productos de la tabla
DELIMITER //
=======

DELIMITER ;

DELIMITER //

>>>>>>> Carlos_Branch
CREATE PROCEDURE ObtenerProductos()
BEGIN
    SELECT * FROM productos;
END //
<<<<<<< HEAD
DELIMITER ;

-- Busca un producto por nombre en la tabla de productos
DELIMITER //
=======

DELIMITER ;

DELIMITER //

>>>>>>> Carlos_Branch
CREATE PROCEDURE BuscarProductoPorNombre(
    IN nombreProducto VARCHAR(255)
)
BEGIN
    SELECT *
    FROM productos
    WHERE nombre_producto = nombreProducto;
END//
<<<<<<< HEAD
DELIMITER ;

-- Valida el login comparando el nombre de usuario y contraseña
DELIMITER //
=======

DELIMITER ;
DELIMITER //

CREATE PROCEDURE ActualizarProductoPorID(
    IN p_idProducto INT,
    IN p_nombreProducto VARCHAR(255)
)
BEGIN
    UPDATE productos
    SET nombre_producto = p_nombreProducto
    WHERE id_producto = p_idProducto;
END //

DELIMITER ;



DELIMITER //


>>>>>>> Carlos_Branch
DROP PROCEDURE IF EXISTS ValidarLogin;
DELIMITER //
CREATE PROCEDURE ValidarLogin(
    IN p_Usu VARCHAR(10), 
    IN p_Contr VARCHAR(255)
)
BEGIN
    DECLARE vali_Contra VARCHAR(255);
    SELECT passw INTO vali_Contra FROM Usuarios WHERE Usuario = p_Usu LIMIT 1;
    IF vali_Contra IS NOT NULL AND vali_Contra = p_Contr THEN
        SELECT 'Correcto' AS Resultado;
    ELSE
        SELECT 'Incorrecto' AS Resultado;
    END IF;
END //
DELIMITER ;

<<<<<<< HEAD
-- Agrega un proveedor a la tabla de proveedores
DELIMITER //
=======

DELIMITER //

>>>>>>> Carlos_Branch
CREATE PROCEDURE AgregarProveedor(
    IN nombre_proveedor VARCHAR(255),
    IN telefono_proveedor VARCHAR(255)
)
BEGIN
    INSERT INTO proveedores (nombre_proveedor, telefono) 
    VALUES (nombre_proveedor, telefono_proveedor);
END //
<<<<<<< HEAD
DELIMITER ;

-- Obtiene todos los proveedores de la tabla
DELIMITER //
=======

DELIMITER ;

DELIMITER //

>>>>>>> Carlos_Branch
CREATE PROCEDURE ObtenerProveedores()
BEGIN
    SELECT * FROM proveedores;
END //
<<<<<<< HEAD
DELIMITER ;

-- Busca un proveedor por nombre en la tabla de proveedores
DELIMITER //
=======

DELIMITER ;

DELIMITER //

>>>>>>> Carlos_Branch
CREATE PROCEDURE BuscarProveedorPorNombre(
    IN nombreProveedor VARCHAR(255)
)
BEGIN
    SELECT *
    FROM proveedores
    WHERE nombre_proveedor = nombreProveedor;
END//
<<<<<<< HEAD
=======

DELIMITER ;

DELIMITER //

CREATE PROCEDURE EliminarProveedor(
    IN p_nombre_proveedor VARCHAR(255),
    IN p_telefono_proveedor VARCHAR(255)
)
BEGIN
    DECLARE proveedor_id INT;
    SELECT id_proveedor INTO proveedor_id
    FROM proveedores
    WHERE nombre_proveedor = p_nombre_proveedor AND telefono = p_telefono_proveedor
    LIMIT 1;
    IF proveedor_id IS NOT NULL THEN
        DELETE FROM proveedores
        WHERE id_proveedor = proveedor_id;
    END IF;
END //

DELIMITER ;


DELIMITER //

CREATE PROCEDURE EditarProveedor(
    IN p_id_proveedor INT,
    IN p_nuevo_nombre_proveedor VARCHAR(255),
    IN p_nuevo_telefono_proveedor VARCHAR(255)
)
BEGIN
    UPDATE proveedores
    SET nombre_proveedor = p_nuevo_nombre_proveedor,
        telefono = p_nuevo_telefono_proveedor
    WHERE id_proveedor = p_id_proveedor;
END //

DELIMITER ;

DELIMITER //

CREATE PROCEDURE VerificarRepetidoProveedor(
    IN p_nombre_proveedor VARCHAR(255),
    IN p_telefono_proveedor VARCHAR(255)
)
BEGIN
    DECLARE contador INT;

    SELECT COUNT(*) INTO contador
    FROM proveedores
    WHERE nombre_proveedor = p_nombre_proveedor AND telefono = p_telefono_proveedor;

    IF contador > 0 THEN
        SELECT 1 AS repetido;
    ELSE
        SELECT 0 AS repetido;
    END IF;
END //

>>>>>>> Carlos_Branch
DELIMITER ;
