package carritoArtesanias.bll;

import carritoArtesanias.dal.DAL_ListaVenta;
import carritoArtesanias.el.Venta;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_ListaVenta {
    private LinkedList<Venta> listaVenta;
    
    public LinkedList<Venta> obtenerTodasLasVentas(Connection dbCon) {
        try {
            DAL_ListaVenta dal_ListaVenta = new DAL_ListaVenta(dbCon, null);
            return dal_ListaVenta.obtenerTodasLasVentas();
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    
    public LinkedList<Venta> obtenerVentasDelUsuario(Connection dbCon,Venta venta) {
        try {
            DAL_ListaVenta dal_ListaVenta = new DAL_ListaVenta(dbCon, venta);
            return dal_ListaVenta.obtenerVentasDelUsuario();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
