DELIMITER //

CREATE TRIGGER before_insert_gavetas
BEFORE INSERT ON gavetas
FOR EACH ROW
BEGIN
    DECLARE valid_tamanio BOOLEAN;

    SET valid_tamanio = NEW.tamanio IN ('GRANDE', 'PEQUEÑO', 'MEDIANO');

    IF NOT valid_tamanio THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El tamaño debe ser GRANDE, PEQUEÑO o MEDIANO';
    END IF;
END //

DELIMITER ;
DELIMITER //

CREATE TRIGGER before_update_gavetas
BEFORE UPDATE ON gavetas
FOR EACH ROW
BEGIN
    DECLARE valid_tamanio BOOLEAN;

    -- Verificar si el nuevo tamaño ingresado es válido
    SET valid_tamanio = NEW.tamanio IN ('GRANDE', 'PEQUEÑO', 'MEDIANO');

    -- Si el tamaño no es válido, generar un error
    IF NOT valid_tamanio THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Error: El tamaño debe ser GRANDE, PEQUEÑO o MEDIANO';
    END IF;
END //

DELIMITER ;

-- Trigger para evitar repetición de números de teléfono
DELIMITER //
CREATE TRIGGER before_insert_telefono_unique
BEFORE INSERT ON supermercados
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM supermercados WHERE telefono = NEW.telefono) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede insertar. Número de teléfono duplicado.';
    END IF;
END;
//

CREATE TRIGGER before_update_telefono_unique
BEFORE UPDATE ON supermercados
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM supermercados WHERE telefono = NEW.telefono AND id_supermercado <> NEW.id_supermercado) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede actualizar. Número de teléfono duplicado.';
    END IF;
END;
//

-- Trigger para evitar repetición de nombres
CREATE TRIGGER before_insert_nombre_unico
BEFORE INSERT ON supermercados
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM supermercados WHERE nombre = NEW.nombre) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede insertar. Nombre duplicado.';
    END IF;
END;
//

CREATE TRIGGER before_update_nombre_unico
BEFORE UPDATE ON supermercados
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM supermercados WHERE nombre = NEW.nombre AND id_supermercado <> NEW.id_supermercado) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede actualizar. Nombre duplicado.';
    END IF;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER codGavetas
BEFORE INSERT ON gavetas
FOR EACH ROW
BEGIN
    DECLARE nuevoCodigo VARCHAR(10);
    SET nuevoCodigo = CONCAT('GA', LPAD((SELECT COALESCE(MAX(id), 0) + 1 FROM gavetas), 3, '0'));

    SET NEW.codigo_GA = nuevoCodigo;
END;
//
DELIMITER ;


DELIMITER //
CREATE TRIGGER codProduct
BEFORE INSERT ON productos
FOR EACH ROW
BEGIN
    DECLARE nuevoCodigo VARCHAR(10);
    SET nuevoCodigo = CONCAT('PRDT', LPAD((SELECT COALESCE(MAX(id_producto), 0) + 1 FROM productos), 3, '0'));

    SET NEW.codigo_Product = nuevoCodigo;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER codProvedor
BEFORE INSERT ON proveedores
FOR EACH ROW
BEGIN
    DECLARE nuevoCodigo VARCHAR(10);
    SET nuevoCodigo = CONCAT('PROV', LPAD((SELECT COALESCE(MAX(id_proveedor), 0) + 1 FROM proveedores), 3, '0'));

    SET NEW.codigo_Provee = nuevoCodigo;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER codSuper
BEFORE INSERT ON supermercados
FOR EACH ROW
BEGIN
    DECLARE nuevoCodigo VARCHAR(10);
    SET nuevoCodigo = CONCAT('SUPER', LPAD((SELECT COALESCE(MAX(id_supermercado), 0) + 1 FROM supermercados), 3, '0'));

    SET NEW.codigo_Super = nuevoCodigo;
END;
//
DELIMITER ;

DELIMITER //
CREATE TRIGGER codEntrada
BEFORE INSERT ON entradas_inventario
FOR EACH ROW
BEGIN
    DECLARE nuevoCodigo VARCHAR(10);
    SET nuevoCodigo = CONCAT('ENTR', LPAD((SELECT COALESCE(MAX(id) + 1, 1) FROM entradas_inventario), 3, '0'));

    SET NEW.codigo_entrada = nuevoCodigo;
END;
//
DELIMITER ;

-- ACTUALIZAR ESTADO DE LAS GAVETAS DEPUES DE UN ENVIO
DELIMITER $$

CREATE TRIGGER ActualizarEstadoGavetaDespuesDeEnvio
AFTER INSERT ON envios
FOR EACH ROW
BEGIN
    UPDATE gavetas
    SET id_estado = 2
    WHERE id = NEW.id_gaveta;
END$$

DELIMITER ;
-- triger para asignar el codigo a envioGee
DELIMITER //
CREATE TRIGGER before_insert_envio_general
BEFORE INSERT ON envios_generales
FOR EACH ROW
BEGIN
    SET NEW.codigoEnvioG = CONCAT('EG', LPAD((SELECT COUNT(*) FROM envios_generales) + 1, 3, '0'));
END;
//
DELIMITER ;
--  despues de agregar producto
DROP TRIGGER IF EXISTS AfterInsertProducto;
DELIMITER //
CREATE TRIGGER AfterInsertProducto
AFTER INSERT ON productos
FOR EACH ROW
BEGIN
    INSERT INTO detalle_inventario (id_producto, nombre_producto, cantidad_total_kg)
    VALUES (NEW.id_producto, NEW.nombre_producto, 0);
END; //
DELIMITER ;
--  despues de actualizar producto
DROP TRIGGER IF EXISTS AfterUpdateProductoNombre;
DELIMITER //
CREATE TRIGGER AfterUpdateProductoNombre
AFTER UPDATE ON productos
FOR EACH ROW
BEGIN
    IF OLD.nombre_producto <> NEW.nombre_producto THEN
        UPDATE detalle_inventario
        SET nombre_producto = NEW.nombre_producto
        WHERE id_producto = NEW.id_producto;
    END IF;
END; //
DELIMITER ;
--  despues de eliminar producto
DROP TRIGGER IF EXISTS AfterDeleteProducto;
DELIMITER //
CREATE TRIGGER AfterDeleteProducto
AFTER DELETE ON productos
FOR EACH ROW
BEGIN
    DELETE FROM detalle_inventario
    WHERE id_producto = OLD.id_producto;
END; //
DELIMITER ;

-- Aumenta cantidad total de kg
DELIMITER //
CREATE TRIGGER AumentarKGTotalDetalle_inventario
AFTER INSERT ON entradas_inventario
FOR EACH ROW
BEGIN
    DECLARE total_existente DECIMAL(10,2);

    -- Obtener la cantidad total existente para el producto en detalle_inventario
    SELECT cantidad_total_kg INTO total_existente
    FROM detalle_inventario
    WHERE id_producto = NEW.id_producto;

    IF total_existente IS NULL THEN
        INSERT INTO detalle_inventario (id_producto, nombre_producto, cantidad_total_kg)
        VALUES (NEW.id_producto, (SELECT nombre_producto FROM productos WHERE id_producto = NEW.id_producto), NEW.cantidad_kg);
    ELSE
        UPDATE detalle_inventario
        SET cantidad_total_kg = total_existente + NEW.cantidad_kg
        WHERE id_producto = NEW.id_producto;
    END IF;
END;
//
DELIMITER ;



