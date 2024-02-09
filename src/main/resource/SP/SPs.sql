-- Agrega un producto a la tabla de productos
DELIMITER //
CREATE PROCEDURE AgregarProducto(
    IN nombre_producto VARCHAR(255)
)
BEGIN
    INSERT INTO productos (nombre_producto) VALUES (nombre_producto);
END //
DELIMITER ;

-- Obtiene todos los productos de la tabla
DELIMITER //
CREATE PROCEDURE ObtenerProductos()
BEGIN
    SELECT * FROM productos;
END //
DELIMITER ;

-- Busca un producto por nombre en la tabla de productos
DELIMITER //
CREATE PROCEDURE BuscarProductoPorNombre(
    IN nombreProducto VARCHAR(255)
)
BEGIN
    SELECT *
    FROM productos
    WHERE nombre_producto = nombreProducto;
END//
DELIMITER ;

-- Valida el login comparando el nombre de usuario y contraseña
DELIMITER //
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

-- Agrega un proveedor a la tabla de proveedores
DELIMITER //
CREATE PROCEDURE AgregarProveedor(
    IN nombre_proveedor VARCHAR(255),
    IN telefono_proveedor VARCHAR(255)
)
BEGIN
    INSERT INTO proveedores (nombre_proveedor, telefono) 
    VALUES (nombre_proveedor, telefono_proveedor);
END //
DELIMITER ;

-- Obtiene todos los proveedores de la tabla
DELIMITER //
CREATE PROCEDURE ObtenerProveedores()
BEGIN
    SELECT * FROM proveedores;
END //
DELIMITER ;

-- Busca un proveedor por nombre en la tabla de proveedores
DELIMITER //
CREATE PROCEDURE BuscarProveedorPorNombre(
    IN nombreProveedor VARCHAR(255)
)
BEGIN
    SELECT *
    FROM proveedores
    WHERE nombre_proveedor = nombreProveedor;
END//
DELIMITER ;
