package carritoArtesanias.dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import carritoArtesanias.el.Producto;

/**
 *
 * @author chee <chee_unp@edu.mx>
 */
public class DAL_ListaProducto {
    private Producto producto;
    private Connection dbCon;
    private LinkedList<Producto> listaProductos;
    
    public DAL_ListaProducto(Connection _dbCon, Producto _producto) {
        dbCon = _dbCon;
        if (_producto != null) {
            this.producto = _producto;
        } else {
            this.producto = new Producto();
        }
    }

    public DAL_ListaProducto() {
    }
    
    
    
    public LinkedList<Producto> obtenerTodosLosProfesores() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        int verificador = 0;

        this.listaProductos = new LinkedList<Producto>();
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Producto_ConsultarTodos_SP()}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
            //
            while (rs.next()) {
                this.producto = new Producto();
                this.producto.setIdProducto(rs.getString("ID_Producto"));
                this.producto.setNombre(rs.getString("Nombre"));
                this.producto.setDescripcion(rs.getString("Descripcion"));
                this.producto.setRegion(rs.getString("Region"));
                this.producto.setCosto(rs.getDouble("Costo"));
                this.producto.setExistencia(rs.getInt("Existencia"));
                this.listaProductos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return null;
        }
        return this.listaProductos;
    }
    
    
      public LinkedList<Producto> listaProductosPorRegionToDatabase() {
        CallableStatement cstmt = null;
        ResultSet rs = null;
        this.listaProductos = new LinkedList<Producto>();
        int verificador = 0;
        try {
            cstmt = this.dbCon.prepareCall("{call tbl_Producto_ConsultarPorRegion_SP(?)}", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            cstmt.setString("In_ID_Region", this.producto.getRegion());
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

            if (rs.next()) {
                this.producto = new Producto();
                this.producto.setIdProducto(rs.getString("ID_Producto"));
                this.producto.setNombre(rs.getString("Nombre"));
                this.producto.setDescripcion(rs.getString("Descripcion"));
                this.producto.setRegion(rs.getString("Region"));
               this.producto.setCosto(rs.getDouble("Costo"));
               this.producto.setExistencia(rs.getInt("Existencia"));
               this.listaProductos.add(producto);
               // verificador = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Failed to add the record: " + e.toString());
            return  this.listaProductos;
        }
        return  this.listaProductos;
    }
      
      
    
}
