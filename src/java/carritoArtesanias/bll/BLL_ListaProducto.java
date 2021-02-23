package carritoArtesanias.bll;

import carritoArtesanias.dal.DAL_ListaProducto;
import carritoArtesanias.dal.DAL_Producto;
import carritoArtesanias.el.Producto;
import java.sql.Connection;
import java.util.LinkedList;
/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class BLL_ListaProducto {
    
    private LinkedList<Producto> listaProducto;

   public LinkedList<Producto> obtenerTodosLosProducto(Connection dbCon) {
       
        try {
            DAL_ListaProducto dal_ListaProducto = new DAL_ListaProducto(dbCon, null);
            return dal_ListaProducto.obtenerTodosLosProfesores();
        } catch (Exception ex) {
            throw ex;
        }
    }
   
   
   public LinkedList<Producto> obtenerTodosLosProductosPorRegion(Connection dbCon,Producto producto) {
       
        try {
            DAL_ListaProducto dal_ListaProducto = new DAL_ListaProducto(dbCon, producto);
            return dal_ListaProducto.listaProductosPorRegionToDatabase();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
