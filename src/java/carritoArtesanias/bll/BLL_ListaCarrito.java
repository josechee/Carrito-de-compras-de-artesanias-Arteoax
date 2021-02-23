/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.bll;

import carritoArtesanias.dal.DAL_ListaCarrito;
import carritoArtesanias.el.Carrito;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class BLL_ListaCarrito {
    private LinkedList<Carrito> listaCarrito;

   public LinkedList<Carrito> obtenerTodosLosCarritos(Connection dbCon) {
       
        try {
            DAL_ListaCarrito dal_ListaCarrito = new DAL_ListaCarrito(dbCon, null);
            return dal_ListaCarrito.obtenerTodosLosCarritos();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
