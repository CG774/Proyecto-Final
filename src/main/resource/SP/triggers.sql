DELIMITER //

CREATE TRIGGER verificarIngresoProvee
BEFORE INSERT ON proveedores
FOR EACH ROW
BEGIN
    DECLARE contador_nombre INT;

    SELECT COUNT(*) INTO contador_nombre
    FROM proveedores
    WHERE nombre_proveedor = NEW.nombre_proveedor;

    IF contador_nombre > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se permite insertar registros duplicados en la tabla proveedores.';
    END IF;
END //

DELIMITER ;

DELIMITER //

CREATE TRIGGER verificarUpdateProvee
BEFORE UPDATE ON proveedores
FOR EACH ROW
BEGIN
    DECLARE contador_nombre INT;

    SELECT COUNT(*) INTO contador_nombre
    FROM proveedores
    WHERE nombre_proveedor = NEW.nombre_proveedor AND id_proveedor <> NEW.id_proveedor;

    IF contador_nombre > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se permite actualizar a valores que ya existen en la tabla proveedores.';
    END IF;
END //

DELIMITER ;
DELIMITER //

CREATE TRIGGER verificarIngresoProducto
BEFORE INSERT ON productos
FOR EACH ROW
BEGIN
    DECLARE contador_nombre INT;

    SELECT COUNT(*) INTO contador_nombre
    FROM productos
    WHERE nombre_producto = NEW.nombre_producto;

    IF contador_nombre > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se permite insertar registros duplicados en la tabla productos.';
    END IF;
END //

DELIMITER ;
DELIMITER //

CREATE TRIGGER verificarUpdateProducto
BEFORE UPDATE ON productos
FOR EACH ROW
BEGIN
    DECLARE contador_nombre INT;

    SELECT COUNT(*) INTO contador_nombre
    FROM productos
    WHERE nombre_producto = NEW.nombre_producto AND id_producto <> NEW.id_producto;

    IF contador_nombre > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se permite actualizar a valores que ya existen en la tabla productos.';
    END IF;
END //

DELIMITER ;

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
-- 


