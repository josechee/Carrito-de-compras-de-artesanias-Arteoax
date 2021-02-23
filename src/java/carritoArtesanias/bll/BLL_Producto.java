/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.bll;

import carritoArtesanias.dal.DAL_Producto;
import carritoArtesanias.el.Producto;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_Producto {

    public String AddProductoToDataBase(Connection dbCon, Producto producto) throws Exception {
        try {
            DAL_Producto dal_Producto = new DAL_Producto(dbCon, producto);
            return dal_Producto.addProductoToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    public Producto QueryProductoDataBase(Connection dbCon, Producto producto) throws Exception {
        try {
             DAL_Producto dal_Producto = new DAL_Producto(dbCon, producto);
            return dal_Producto.queryProductoToDatabase();
        } catch (Exception ex) {
            throw ex;
        }
    }

    
}
