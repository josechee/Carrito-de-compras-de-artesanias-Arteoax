/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.bll;

import carritoArtesanias.dal.DAL_Carrito;
import carritoArtesanias.dal.DAL_Producto;
import carritoArtesanias.el.Carrito;
import carritoArtesanias.el.Producto;
import java.sql.Connection;

/**
 *
 * @author PC
 */
public class BLL_Carrito {
    
    public String AddCarritoToDataBase(Connection dbCon, Carrito carrito) throws Exception {
        try {
            DAL_Carrito dal_carrito = new DAL_Carrito(dbCon, carrito);
            return dal_carrito.addCarritoToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public Carrito QueryCarritoDataBase(Connection dbCon, Carrito carrito) throws Exception {
        try {
             DAL_Carrito dal_carrito = new DAL_Carrito(dbCon, carrito);
            return dal_carrito.queryCarritoToDatabase();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    public int EliminarCarritoDataBase(Connection dbCon, Carrito carrito) throws Exception {
        try {
             DAL_Carrito dal_carrito = new DAL_Carrito(dbCon, carrito);
            return dal_carrito.eliminarCaritos();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
