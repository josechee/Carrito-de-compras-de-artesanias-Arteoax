/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carritoArtesanias.bll;

import carritoArtesanias.dal.DAL_Venta;
import carritoArtesanias.el.Venta;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_Venta {

    public String AddVentaToDataBase(Connection dbCon, Venta _venta) throws Exception {
        try {
            DAL_Venta dal_venta = new DAL_Venta(dbCon, _venta);
            return dal_venta.addVentaToDataBase();
        } catch (Exception ex) {
            throw ex;
        }
    }

    
    
    public Venta QueryUsuarioDataBase(Connection dbCon, String  idUsuario) throws Exception {
        try {
            DAL_Venta dal_venta = new DAL_Venta(dbCon, null);
            return dal_venta.queryVentaToDatabase();
          //  return dal_usuario.loginUsuarioToDatabase(idUsuario);
        } catch (Exception ex) {
            throw ex;
        }
     }  
    
    public LinkedList<Venta> QueryVentaTodasDataBase(Connection dbCon, String idVenta) throws Exception {
        try {
            DAL_Venta dal_venta = new DAL_Venta(dbCon, null);
            return dal_venta.obtenerTodasLasVentas();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    

}
