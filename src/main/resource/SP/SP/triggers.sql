DELIMITER //

CREATE TRIGGER verificarIngresoProvee
BEFORE INSERT ON proveedores
FOR EACH ROW
BEGIN
    DECLARE contador_nombre INT;
    DECLARE contador_telefono INT;

    SELECT COUNT(*) INTO contador_nombre
    FROM proveedores
    WHERE nombre_proveedor = NEW.nombre_proveedor;

    SELECT COUNT(*) INTO contador_telefono
    FROM proveedores
    WHERE telefono = NEW.telefono;

    IF contador_nombre > 0 OR contador_telefono > 0 THEN
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
    DECLARE contador_telefono INT;

    SELECT COUNT(*) INTO contador_nombre
    FROM proveedores
    WHERE nombre_proveedor = NEW.nombre_proveedor AND id_proveedor <> NEW.id_proveedor;

    SELECT COUNT(*) INTO contador_telefono
    FROM proveedores
    WHERE telefono = NEW.telefono AND id_proveedor <> NEW.id_proveedor;

    IF contador_nombre > 0 OR contador_telefono > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se permite actualizar a valores que ya existen en la tabla proveedores.';
    END IF;
END //

DELIMITER ;
