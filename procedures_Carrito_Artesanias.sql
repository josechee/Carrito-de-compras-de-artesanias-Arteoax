use bd_carrito;
-- ----------------------------------------------------------
-- ---------------------USAURIO-------------------------------------

DROP TABLE IF EXISTS tbl_usuario;
CREATE TABLE tbl_usuario(
	ID_Usuario varchar(36) NOT NULL,
    Correo varchar(45) NOT NULL,
    Contraseña varchar(45) NOT NULL,
    PRIMARY KEY (ID_Usuario)
);


-- ...................................................................
-- ...................................................................

DROP PROCEDURE IF EXISTS tbl_Usuario_Insertar_SP;

DELIMITER //
CREATE  PROCEDURE tbl_Usuario_Insertar_SP(
	IN Input_Correo VARCHAR(45),
    IN Input_Contraseña VARCHAR(45)

)
BEGIN
DECLARE idUsuario varchar(36) DEFAULT ' ';
SET idUsuario= (SELECT UUID());

INSERT INTO tbl_usuario(
		ID_Usuario,
        Correo,
        Contraseña)
        VALUES(
        idUsuario,
        Input_Correo,
        Input_Correo
);

SELECT idUsuario;-- retornar el idUsuario que se crea dinamicamente

 -- SELECT 1;	-- 1 si se ejecuto exitosamente el procedimiento 
END //
DELIMITER ;


-- call tbl_Usuario_Insertar_SP('osamani','osmani');
-- --------------------------------------------------------
-- --------------------------------------------------------

DROP PROCEDURE IF EXISTS tbl_Usuario_Consultar_SP;
DELIMITER //
CREATE PROCEDURE tbl_Usuario_Consultar_SP(IN In_ID_Usuario VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_usuario 
	WHERE  ID_Usuario=In_ID_Usuario;
    
SELECT 1;
END//
DELIMITER ;

-- -------------------------------------
-- ---------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Usuario_ConsultarTodos_SP;

DELIMITER //
CREATE PROCEDURE tbl_Usuario_ConsultarTodos_SP()
BEGIN  
     SELECT 
		ID_Usuario,
        Correo,
        Contraseña
	 FROM
	   tbl_usuario;
       
select 1;       
END //
DELIMITER ;


call tbl_Usuario_ConsultarTodos_SP();

-- --------------------------------------------------------



-- -----------------------------------------------------
-- -----------------------------------------------------
DROP TABLE IF EXISTS tbl_producto;
CREATE TABLE tbl_producto(
	ID_Producto varchar(36) NOT NULL,
    Nombre  varchar(45) NOT NULL,
    Descripcion varchar(100) NULL,
    Region varchar(45) NOT NULL,
    Costo double NOT NULL,
    Existencia int NOT NULL,
    PRIMARY KEY (ID_Producto)
);

-- ------------------------------------------------------------
-- ------------------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Producto_Insertar_SP;

DELIMITER //
CREATE  PROCEDURE tbl_Producto_Insertar_SP(
	IN Input_Nombre VARCHAR(45),
    IN Input_Descripcion VARCHAR(100),
    IN Input_Region VARCHAR(45),
    IN Input_Costo double,
    IN Input_Existencia int

)
BEGIN
DECLARE idProducto varchar(36) DEFAULT ' ';
SET idProducto= (SELECT UUID());

INSERT INTO tbl_producto(
		ID_Producto,
        Nombre,
        Descripcion,
        Region,
        Costo,
        Existencia)
        VALUES(
        idProducto,
        Input_Nombre,
        Input_Descripcion,
        Input_Region,
        Input_Costo,
        Input_Existencia
);

SELECT idProducto;-- retornar el idUsuario que se crea dinamicamente

 -- SELECT 1;	-- 1 si se ejecuto exitosamente el procedimiento 
END //
DELIMITER ;


call bd_carrito.tbl_Producto_Insertar_SP('Canasta','Es utilizado todavia en los pueblos para lavar maiz','Papaloapan',150.00,100);

-- -------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Producto_Consultar_SP;
DELIMITER //
CREATE PROCEDURE tbl_Producto_Consultar_SP(IN In_ID_Producto VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_producto 
	WHERE  ID_Producto=In_ID_Producto;
    
SELECT 1;
END//
DELIMITER ;


-- -------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Producto_ConsultarPorRegion_SP;
DELIMITER //
CREATE PROCEDURE tbl_Producto_ConsultarPorRegion_SP(IN In_ID_Region VARCHAR(45))
BEGIN
	
	SELECT  * FROM tbl_producto 
	WHERE  ID_Producto=In_ID_Region;
SELECT 1;
END//
DELIMITER ;

call bd_carrito.tbl_Producto_ConsultarPorRegion_SP('PAPALOAPAN');
-- ---------------------------------------------------------------------------


-- -------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Producto_ConsultarTodos_SP;

DELIMITER //
CREATE PROCEDURE tbl_Producto_ConsultarTodos_SP()
BEGIN  
     SELECT 
        ID_Producto,
        Nombre,
        Descripcion,
        Region,
        Costo,
        Existencia
	 FROM
	   tbl_producto;
       
select 1;       
END //
DELIMITER ;

call bd_carrito.tbl_Producto_ConsultarTodos_SP();

-- -------------------------------------------------------------------
-- -------------------------------------------------------------------

DROP TABLE IF EXISTS tbl_carrito;
CREATE TABLE tbl_carrito(
	ID_Carrito varchar(36) NOT NULL,
    ID_Usuario varchar(36) NOT NULL,
    ID_Producto varchar(36) NOT NULL,
    Cantidad_Producto int  NULL,
        
    PRIMARY KEY (ID_Carrito)
);


-- ------------------------------------------------------------
-- ------------------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Carrito_Insertar_SP;

DELIMITER //
CREATE  PROCEDURE tbl_Carrito_Insertar_SP(
	IN Input_ID_Usuario VARCHAR(36),
    IN Input_ID_Producto VARCHAR(36),
    IN Input_Cantidad_Producto INT

)
BEGIN
DECLARE idCarrito varchar(36) DEFAULT ' ';
SET idCarrito= (SELECT UUID());

INSERT INTO tbl_carrito(
		ID_Carrito,
        ID_Usuario,
        ID_Producto,
        Cantidad_Producto)
        VALUES(
        idCarrito,
        Input_ID_Usuario,
        Input_ID_Producto,
        Input_Cantidad_Producto
);

SELECT idCarrito;-- retornar el idUsuario que se crea dinamicamente

 -- SELECT 1;	-- 1 si se ejecuto exitosamente el procedimiento 
END //
DELIMITER ;

-- ------------------------------------------------------
-- ------------------------------------------------------


DROP PROCEDURE IF EXISTS tbl_Carrito_Consultar_SP;
DELIMITER //
CREATE PROCEDURE tbl_Carrito_Consultar_SP(IN In_ID_Carrito VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_carrito 
	WHERE  ID_Carrito=In_ID_Carrito;
    
SELECT 1;
END//
DELIMITER ;

-- -------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Carritos_ConsultarTodos_SP;

DELIMITER //
CREATE PROCEDURE tbl_Carritos_ConsultarTodos_SP()
BEGIN  
     SELECT 
        ID_Carrito,
        ID_Usuario,
        ID_Producto,
        Cantidad_Productotbl_producto
	 FROM
	   tbl_carrito;
       
select 1;       
END //
DELIMITER ;


-- -------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------

DROP PROCEDURE IF EXISTS tbl_Carrito_Eliminar_SP;

DELIMITER //
CREATE PROCEDURE tbl_Carrito_Eliminar_SP(IN In_ID_Usuario VARCHAR(36))
BEGIN 
	
    DELETE FROM tbl_carrito 
	WHERE ID_Usuario = In_ID_Usuario; 
	
    SELECT 1;
END //
DELIMITER ;

call bd_carrito.tbl_Carrito_Eliminar_SP('54980050-205b-11e9-b334-28d244202eee');
-- -------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS tbl_venta;
CREATE TABLE tbl_venta(
	ID_Venta varchar(36) NOT NULL,
    ID_Usuario varchar(36) NOT NULL,
    ID_Carrito varchar(36) NOT NULL,
    Producto varchar(45) NOT NULL,
    Region varchar(45) NOT NULL,
    Precio double  not null,
    Total_Producto int  NULL,
    Precio_Total double  not null,
    Fecha varchar(45) not null,
        
    PRIMARY KEY (ID_Venta)
);

-- ------------------------------------------------------------
-- ------------------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Venta_Insertar_SP;

DELIMITER //
CREATE  PROCEDURE tbl_Venta_Insertar_SP(
	IN Input_ID_Usuario varchar(36),
    IN Input_ID_Carrito varchar(36),
    IN Input_Producto varchar(45),
    IN Input_Region varchar(45) ,
    IN Input_Precio double,
    IN Input_Total_Producto int,
    IN Input_Precio_Total double

)
BEGIN
DECLARE idVenta varchar(36) DEFAULT ' ';
DECLARE idFecha varchar(36) DEFAULT ' ';
SET idVenta= (SELECT UUID());
SET idFecha= SYSDATE();

INSERT INTO tbl_venta(
		ID_Venta,
		ID_Usuario,
		ID_Carrito,
		Producto,
		Region,
		Precio,
		Total_Producto,
		Precio_Total,
		Fecha)
        VALUES(
        idVenta,
        Input_ID_Usuario,
		Input_ID_Carrito,
    	Input_Producto,
		Input_Region,
		Input_Precio,
		Input_Total_Producto,
		Input_Precio_Total,
		idFecha
);

SELECT idVenta;-- retornar el idUsuario que se crea dinamicamente

 -- SELECT 1;	-- 1 si se ejecuto exitosamente el procedimiento 
END //
DELIMITER ;


-- ------------------------------------------------------------------------
-- -----------------------------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Venta_Consultar_SP;
DELIMITER //
CREATE PROCEDURE tbl_Venta_Consultar_SP(IN In_ID_Venta VARCHAR(36))
BEGIN
	
	SELECT  * FROM tbl_venta 
	WHERE  ID_Venta=In_ID_Venta;
    
SELECT 1;
END//
DELIMITER ;

-- -------------------------------------------------------------------------------------------
-- -------------------------------------------------------------------------------------------
DROP PROCEDURE IF EXISTS tbl_Venta_ConsultarTodos_SP;

DELIMITER //
CREATE PROCEDURE tbl_Venta_ConsultarTodos_SP()
BEGIN  
     SELECT 
        ID_Venta,
		ID_Usuario,
		ID_Carrito,
		Producto,
		Region,
		Precio,
		Total_Producto,
		Precio_Total,
		Fecha
	 FROM
	   tbl_venta;
       
select 1;       
END //
DELIMITER ;
-- ----------------------------
call bd_carrito.tbl_Venta_ConsultarTodos_SP();
-- -----------------------------------------------------------------------------------------------------
-- -----------------------------------------------------------------------------------------------------
DROP PROCEDURE IF EXISTS consultarVentasDelUsuario_SP;

DELIMITER //
CREATE PROCEDURE consultarVentasDelUsuario_SP(IN In_ID_Usuario VARCHAR(36))
BEGIN  
     select  *from 
     tbl_venta  
     where 
     ID_Usuario=In_ID_Usuario;
     
END //
DELIMITER ;
