package carritoArtesanias.dal;

import carritoArtesanias.el.Venta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author PC
 */
public class DAL_ListaVenta {
    private Venta venta;
    private Connection dbCon;

    public DAL_ListaVenta(Connection _dbCon, Venta _venta) {
        dbCon = _dbCon;
        if (_venta != null) {
            this.venta = _venta;
        } else {
            this.venta = new Venta();
        }
    }
    
       public LinkedList<Venta> obtenerTodasLasVentas() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;

        LinkedList<Venta> listaVenta = new LinkedList<Venta>();
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Venta_ConsultarTodos_SP()}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           boolean results = cstmt.execute();
            int rowsAffected = 0;

            while (results || rowsAffected != -1) {
                if (results) {
                    rs = cstmt.getResultSet();
                    break;
                } else {
                    rowsAffected = cstmt.getUpdateCount();
                }
                results = cstmt.getMoreResults();

            }
            while (rs.next()) {
                this.venta = new Venta();
                this.venta.setIdVenta(rs.getString("ID_Venta"));
                this.venta.setIdUsuario(rs.getString("ID_Usuario"));
                this.venta.setIdCarrito(rs.getString("ID_Carrito"));
                this.venta.setProducto(rs.getString("Producto"));
                this.venta.setRegion(rs.getString("Region"));
                this.venta.setPrecio(rs.getDouble("Precio"));
                this.venta.setCantidadProoducto(rs.getInt("Total_Producto"));
                this.venta.setPrecioTotal(rs.getDouble("Precio_Total"));
                this.venta.setFecha(rs.getString("Fecha"));
                
                listaVenta.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaVenta;
    }
       
       
       public LinkedList<Venta> obtenerVentasDelUsuario() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;

        LinkedList<Venta> listaVenta = new LinkedList<Venta>();
        try {
            cstmt = this.dbCon.prepareCall("{call consultarVentasDelUsuario_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           cstmt.setString("In_ID_Usuario", this.venta.getIdUsuario());
            boolean results = cstmt.execute();
            int rowsAffected = 0;

            while (results || rowsAffected != -1) {
                if (results) {
                    rs = cstmt.getResultSet();
                    break;
                } else {
                    rowsAffected = cstmt.getUpdateCount();
                }
                results = cstmt.getMoreResults();

            }
            while (rs.next()) {
                this.venta = new Venta();
                this.venta.setIdVenta(rs.getString("ID_Venta"));
                this.venta.setIdUsuario(rs.getString("ID_Usuario"));
                this.venta.setIdCarrito(rs.getString("ID_Carrito"));
                this.venta.setProducto(rs.getString("Producto"));
                this.venta.setRegion(rs.getString("Region"));
                this.venta.setPrecio(rs.getDouble("Precio"));
                this.venta.setCantidadProoducto(rs.getInt("Total_Producto"));
                this.venta.setPrecioTotal(rs.getDouble("Precio_Total"));
                this.venta.setFecha(rs.getString("Fecha"));
                
                listaVenta.add(venta);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return listaVenta;
    }

     
}
